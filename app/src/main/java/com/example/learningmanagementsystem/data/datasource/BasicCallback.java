package com.example.learningmanagementsystem.data.datasource;

public interface BasicCallback<T> {
    void onSuccess(T t);
    void onFailed(String errorMessage);
}
