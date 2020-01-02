package com.example.learningmanagementsystem.data.datasource;

import android.content.Context;

import com.example.learningmanagementsystem.model.Lesson;


public interface LessonDataSource {
    void getLesson(Context context, GetLessonCallback callback, int id);

    interface GetLessonCallback extends BasicCallback<Lesson>{}
}
