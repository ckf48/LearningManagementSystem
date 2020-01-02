package com.example.learningmanagementsystem.view.myCourse;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.learningmanagementsystem.R;
import com.example.learningmanagementsystem.databinding.CourseRecyclerItemBinding;
import com.example.learningmanagementsystem.model.CourseBriefInfo;
import com.example.learningmanagementsystem.util.base.ViewModelFragment;
import com.example.learningmanagementsystem.util.recycler.DataBindingRecyclerAdapter;
import com.example.learningmanagementsystem.util.recycler.DataBindingRecyclerViewHolder;
import com.example.learningmanagementsystem.view.MyHandler;

import java.util.List;
import java.util.Objects;


public class MyCourseFragment extends ViewModelFragment<MyCourseViewModel> {
    private CourseAdapter courseAdapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void setMenu() {
        //ignore
    }

    @Override
    protected void afterCreateVM(View root) {
        recyclerView = root.findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = root.findViewById(R.id.swipe);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mSwipeRefreshLayout.setOnRefreshListener(() -> mVM.refresh());
        courseAdapter = new CourseAdapter(
                Objects.requireNonNull(getActivity()).getLayoutInflater(),
                null,
                R.layout.course_recycler_item,
                com.yuri.elearning.BR.course);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        mVM.getCourseLiveData().observe(getViewLifecycleOwner(), course -> {
            courseAdapter.setDataList(course);
            mSwipeRefreshLayout.setRefreshing(false);
        });
        mVM.getLogin().observe(getViewLifecycleOwner(), aBoolean -> {
            if (!aBoolean) Toast.makeText(requireContext(), "请登录", Toast.LENGTH_SHORT).show();
        });

        mVM.refresh();
    }

    @Override
    protected void initVM() {
        mVM = ViewModelProviders.of(this).get(MyCourseViewModel.class);
    }

    @Override
    protected int getLayout() {
        return R.layout.course_recycler;
    }

    private class CourseAdapter extends DataBindingRecyclerAdapter<CourseRecyclerItemBinding, CourseBriefInfo> {
        public CourseAdapter(LayoutInflater layoutInflater, List<CourseBriefInfo> dataList, int layoutId, int brId) {
            super(layoutInflater, dataList, layoutId, brId);
        }

        @Override
        protected void initViewHolder(CourseRecyclerItemBinding courseRecyclerItemBinding) {
            courseRecyclerItemBinding.setHandler(new MyHandler());
        }

        @Override
        protected void afterBindVH(DataBindingRecyclerViewHolder holder, int position) {
            String url =dataList.get(position).cover;
            if (url == null) return;
            url = RESOURCE_URL + url;
            Glide.with(holder.itemView)
                    .load(url)
                    .centerCrop()
                    .into(db.courseImage);
        }
    }
}
