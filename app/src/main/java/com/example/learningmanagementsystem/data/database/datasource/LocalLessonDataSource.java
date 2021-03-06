package com.example.learningmanagementsystem.data.database.datasource;

import android.content.Context;
import android.os.AsyncTask;

import com.example.learningmanagementsystem.data.database.AppDatabase;
import com.example.learningmanagementsystem.data.database.dao.LessonDao;
import com.example.learningmanagementsystem.data.datasource.LessonDataSource;
import com.example.learningmanagementsystem.model.Lesson;

import java.util.concurrent.ExecutionException;

public class LocalLessonDataSource extends AbstractLocalDataSource implements LessonDataSource {
    private final LessonDao mLessonDao;


    public LocalLessonDataSource(AppDatabase appDatabase) {
        super(appDatabase);
        mLessonDao = appDatabase.lessonDao();
    }

    private static class selectLessonTask extends AsyncTask<Integer, Void, Lesson> {
        private LessonDao mLessonDao;

        public selectLessonTask(LessonDao lessonDao) {
            mLessonDao = lessonDao;
        }

        @Override
        protected Lesson doInBackground(Integer... integers) {
            return mLessonDao.select(integers[0]);
        }
    }

    private static class insertLessonTask extends AsyncTask<Lesson, Void, Void> {
        private LessonDao mLessonDao;

        public insertLessonTask(LessonDao lessonDao) {
            mLessonDao = lessonDao;
        }

        @Override
        protected Void doInBackground(Lesson... lessons) {
            mLessonDao.insert(lessons);
            return null;
        }
    }

    @Override
    public void getLesson(Context context, GetLessonCallback callback, int id) {
        Lesson lesson = null;
        try {
            lesson = new selectLessonTask(mLessonDao).execute(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        if (lesson == null) {
            callback.onFailed("local not found");
        } else {
            callback.onSuccess(lesson);
        }
    }

    @Override
    public void getCalendar(Context context, int uid, int year, int month, GetCalendarCallback callback) {

    }

    public void insertLesson(Lesson lesson) {
        new insertLessonTask(mLessonDao).execute(lesson);
    }
}
