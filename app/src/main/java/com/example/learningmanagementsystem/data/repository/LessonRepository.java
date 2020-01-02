package com.example.learningmanagementsystem.data.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.learningmanagementsystem.data.database.AppDatabase;
import com.example.learningmanagementsystem.data.database.datasource.LocalLessonDataSource;
import com.example.learningmanagementsystem.data.datasource.LessonDataSource;
import com.example.learningmanagementsystem.data.network.datasource.RemoteLessonDataSource;
import com.example.learningmanagementsystem.model.Lesson;


public class LessonRepository implements LessonDataSource {
    private static final String TAG = "LessonRepository";
    private final RemoteLessonDataSource remote;
    private final LocalLessonDataSource local;

    public LessonRepository(AppDatabase appDatabase) {
        remote = new RemoteLessonDataSource();
        local = new LocalLessonDataSource(appDatabase);
    }

    @Override
    public void getLesson(Context context, GetLessonCallback callback, int id) {
        Log.d(TAG, "getLesson: ");
        NetworkInfo info = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            Log.d(TAG, "getLesson: remote");
            remote.getLesson(context, new GetLessonCallback() {
                @Override
                public void onSuccess(Lesson lesson) {
                    callback.onSuccess(lesson);
                    local.insertLesson(lesson);
                }

                @Override
                public void onFailed(String errorMessage) {
                }
            }, id);
        } else {
            Log.d(TAG, "getLesson: local");
            local.getLesson(context, new GetLessonCallback() {
                @Override
                public void onSuccess(Lesson lesson) {
                    callback.onSuccess(lesson);
                }

                @Override
                public void onFailed(String errorMessage) {
                }
            }, id);
        }
    }
}