package com.example.learningmanagementsystem.util.base;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.learningmanagementsystem.data.Repository;

public abstract class BaseViewModel extends AndroidViewModel {
    protected final String TAG = getClass().getSimpleName();
    protected Repository mRepository;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        Log.i(TAG, "BaseViewModel: init repository");
        mRepository = new Repository(application);
        Log.i(TAG, "BaseViewModel: init");
        init();
    }

    protected abstract void init();
}
