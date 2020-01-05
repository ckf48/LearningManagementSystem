package com.example.learningmanagementsystem.view.calendar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.learningmanagementsystem.data.datasource.LessonDataSource;
import com.example.learningmanagementsystem.data.repository.UserRepository;
import com.example.learningmanagementsystem.model.LessonBriefInfo;
import com.example.learningmanagementsystem.util.App;
import com.example.learningmanagementsystem.util.base.BaseViewModel;

import java.util.Calendar;
import java.util.List;

public class CalendarViewModel extends BaseViewModel {
    public final MutableLiveData<List<LessonBriefInfo>> mLessons = new MutableLiveData<>();
    public final MutableLiveData<String> message = new MutableLiveData<>();

    @Override
    protected void init() {

    }

    public CalendarViewModel(@NonNull Application application) {
        super(application);
    }

    public void refresh() {
        if (UserRepository.ID == null) return;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        mRepository.lesson.getCalendar(App.getContext(), UserRepository.ID, year, month, new LessonDataSource.GetCalendarCallback() {
            @Override
            public void onSuccess(List<LessonBriefInfo> lessons) {
                mLessons.postValue(lessons);
            }

            @Override
            public void onFailed(String errorMessage) {
                message.postValue(errorMessage);
            }
        });
    }
}
