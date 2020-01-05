package com.example.learningmanagementsystem.view.calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.learningmanagementsystem.MobileNavigationDirections;
import com.example.learningmanagementsystem.R;
import com.example.learningmanagementsystem.databinding.LessonItemBinding;
import com.example.learningmanagementsystem.model.LessonBriefInfo;
import com.example.learningmanagementsystem.util.base.ViewModelFragment;
import com.example.learningmanagementsystem.util.recycler.DataBindingRecyclerAdapter;

import java.util.List;
import java.util.Objects;

public class CalendarFragment extends ViewModelFragment<com.example.learningmanagementsystem.view.calendar.CalendarViewModel> {

    @Override
    protected void afterCreateVM(View root) {
        SwipeRefreshLayout swipe = root.findViewById(R.id.swipe);
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        LessonAdaptor lessonAdaptor = new LessonAdaptor(
                Objects.requireNonNull(getActivity()).getLayoutInflater(),
                null,
                R.layout.lesson_item,
                com.example.learningmanagementsystem.BR.lesson
        );
        recyclerView.setAdapter(lessonAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        swipe.setOnRefreshListener(() -> mVM.refresh());
        mVM.mLessons.observe(getViewLifecycleOwner(), lessonBriefInfos -> {
            lessonAdaptor.setDataList(lessonBriefInfos);
            swipe.setRefreshing(false);
        });
        mVM.message.observe(getViewLifecycleOwner(), s -> Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show());
        mVM.refresh();
    }

    @Override
    protected void initVM() {
        mVM = ViewModelProviders.of(this).get(com.example.learningmanagementsystem.view.calendar.CalendarViewModel.class);
    }

    @Override
    protected int getLayout() {
        return R.layout.calendar_fragment;
    }

    public class Handler {
        public void navToLesson(View view, int id) {
            NavController navController = Navigation.findNavController(view);
            MobileNavigationDirections.ActionGlobalNavLesson action = MobileNavigationDirections.actionGlobalNavLesson(id);
            navController.navigate(action);
        }
    }

    private class LessonAdaptor extends DataBindingRecyclerAdapter<LessonItemBinding, LessonBriefInfo> {

        public LessonAdaptor(LayoutInflater layoutInflater, List<LessonBriefInfo> dataList, int layoutId, int brId) {
            super(layoutInflater, dataList, layoutId, brId);
        }

        @Override
        protected void initViewHolder(LessonItemBinding lessonItemBinding) {
            lessonItemBinding.setHandler(new Handler());
        }
    }
}
