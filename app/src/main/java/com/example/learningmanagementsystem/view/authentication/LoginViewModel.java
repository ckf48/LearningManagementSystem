package com.example.learningmanagementsystem.view.authentication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.learningmanagementsystem.data.datasource.UserDataSource;
import com.example.learningmanagementsystem.data.repository.UserRepository;
import com.example.learningmanagementsystem.model.User;
import com.example.learningmanagementsystem.util.App;
import com.example.learningmanagementsystem.util.base.BaseViewModel;


public class LoginViewModel extends BaseViewModel {
    public MutableLiveData<AuthenticationState> authenticationState;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void authenticate(String account, String password) {
        mRepository.user.login(App.getContext(), new UserDataSource.LoginCallback() {
            @Override
            public void onSuccess(User user) {
                authenticationState.postValue(AuthenticationState.AUTHENTICATED);
                UserRepository.ID = user.id;
                UserRepository.MONEY= user.money;
                UserRepository.NAME = user.name;
            }

            @Override
            public void onFailed(String errorMessage) {
                authenticationState.postValue(AuthenticationState.INVALID_AUTHENTICATION);
            }
        },account, password );
    }

    public void refuseAuthentication() {
        authenticationState.postValue(AuthenticationState.UNAUTHENTICATED);
    }

    @Override
    protected void init() {
        authenticationState = new MutableLiveData<>();
        authenticationState.postValue(AuthenticationState.UNAUTHENTICATED);
    }

    public enum AuthenticationState {
        UNAUTHENTICATED,
        AUTHENTICATED,
        INVALID_AUTHENTICATION
    }
}
