package com.example.learningmanagementsystem.util;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.room.Room;

import com.example.learningmanagementsystem.data.database.AppDatabase;
import com.example.learningmanagementsystem.util.language.LanguageUtil;

public class App extends Application {
    private static Context sContext;
    private final String TAG = getClass().getSimpleName();
    private AppDatabase mAppDatabase;

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: Application");
        super.onCreate();
        sContext = this;
        initLanguage();
        //initDatabase();
    }


    private void initLanguage() {
        String language = (String) SPUtils.get(this, SPUtils.LANGUAGE, String.class);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            LanguageUtil.changeAppLanguage(App.getContext(), language);
        }
    }

    private void initDatabase() {
        mAppDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "android_room_dev.db")
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }
}
