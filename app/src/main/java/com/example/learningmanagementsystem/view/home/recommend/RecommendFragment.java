package com.example.learningmanagementsystem.view.home.recommend;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

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

import static com.example.learningmanagementsystem.data.network.NetTool.RESOURCE_URL;

public class RecommendFragment extends ViewModelFragment<RecommendViewModel> {
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void setMenu() {
        //ignore
    }

    @Override
    protected void initVM() {
        Log.i(TAG, "initVM: ");
        mVM = ViewModelProviders.of(this).get(RecommendViewModel.class);
        Log.i(TAG, "initVM: finish");
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
                com.example.learningmanagementsystem.BR.course);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));


        mVM.getCourseLiveData().observe(this, courses -> {
            courseAdapter.setDataList(courses);
            mSwipeRefreshLayout.setRefreshing(false);
        });
        mVM.refresh();
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
