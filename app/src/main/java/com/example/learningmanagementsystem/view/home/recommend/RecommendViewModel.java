package com.example.learningmanagementsystem.view.home.recommend;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.learningmanagementsystem.data.datasource.CourseDataSource;
import com.example.learningmanagementsystem.model.CourseBriefInfo;
import com.example.learningmanagementsystem.util.App;
import com.example.learningmanagementsystem.util.base.BaseViewModel;

import java.util.List;

public class RecommendViewModel extends BaseViewModel {
    private MutableLiveData<List<CourseBriefInfo>> courseLiveData = new MutableLiveData<>();

    public RecommendViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<CourseBriefInfo>> getCourseLiveData() {
        return courseLiveData;
    }

    @Override
    protected void init() {
    }

    public void refresh() {
        mRepository.course.getAllCourses(App.getContext(), new CourseDataSource.GetAllCourseCallback() {
            @Override
            public void onSuccess(List<CourseBriefInfo> list) {
                courseLiveData.postValue(list);
            }

            @Override
            public void onFailed(String errorMessage) {
                courseLiveData.postValue(null);
            }
        });
    }
}
