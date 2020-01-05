package com.example.learningmanagementsystem.data.datasource;

import android.content.Context;

import com.example.learningmanagementsystem.model.Lesson;
import com.example.learningmanagementsystem.model.LessonBriefInfo;

import java.util.List;

public interface LessonDataSource {
    void getLesson(Context context, GetLessonCallback callback, int id);

    void getCalendar(Context context, int uid, int year, int month, GetCalendarCallback callback);

    interface GetLessonCallback extends BasicCallback<Lesson>{}

    interface GetCalendarCallback extends BasicCallback<List<LessonBriefInfo>> {}
}
