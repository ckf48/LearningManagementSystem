package com.example.learningmanagementsystem.data.database.datasource;

import com.example.learningmanagementsystem.data.database.AppDatabase;

public abstract class AbstractLocalDataSource {
    protected final String TAG = getClass().getSimpleName();
    protected final AppDatabase mAppDatabase;

    public AbstractLocalDataSource(AppDatabase appDatabase) {
        mAppDatabase = appDatabase;
    }
}
