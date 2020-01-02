package com.example.learningmanagementsystem.view.myCourse;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.learningmanagementsystem.data.datasource.CourseDataSource;
import com.example.learningmanagementsystem.data.repository.UserRepository;
import com.example.learningmanagementsystem.model.CourseBriefInfo;
import com.example.learningmanagementsystem.util.App;
import com.example.learningmanagementsystem.util.base.BaseViewModel;

import java.util.List;

public class MyCourseViewModel extends BaseViewModel {
    private MutableLiveData<List<CourseBriefInfo>> courseLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> login = new MutableLiveData<>();

    public MutableLiveData<Boolean> getLogin() {
        return login;
    }

    public MyCourseViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<CourseBriefInfo>> getCourseLiveData() {
        return courseLiveData;
    }

    @Override
    protected void init() {

    }

    public void refresh() {
        Integer uid = UserRepository.ID;
        if (uid == null) {
            login.postValue(false);
            return;
        } else login.postValue(true);
        mRepository.course.getMyCourse(App.getContext(), new CourseDataSource.GetMyCoursesCallback() {
            @Override
            public void onSuccess(List<CourseBriefInfo> courseBriefInfos) {
                courseLiveData.postValue(courseBriefInfos);
            }

            @Override
            public void onFailed(String errorMessage) {

            }
        }, uid);

    }
}
