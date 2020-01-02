package com.example.learningmanagementsystem.view.lesson;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.learningmanagementsystem.data.datasource.LessonDataSource;
import com.example.learningmanagementsystem.model.Lesson;
import com.example.learningmanagementsystem.util.App;
import com.example.learningmanagementsystem.util.base.BaseViewModel;

public class LessonViewModel extends BaseViewModel {
    private MutableLiveData<Lesson> mLesson = new MutableLiveData<>();

    public LessonViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Lesson> getLesson() {
        return mLesson;
    }

    @Override
    protected void init() {

    }

    public void setLesson(int id) {
        mRepository.lesson.getLesson(App.getContext(), new LessonDataSource.GetLessonCallback() {
            @Override
            public void onSuccess(Lesson lesson) {
                Log.d(TAG, "onSuccess: " + lesson);
                mLesson.postValue(lesson);
            }

            @Override
            public void onFailed(String errorMessage) {

            }
        }, id);
    }
}
