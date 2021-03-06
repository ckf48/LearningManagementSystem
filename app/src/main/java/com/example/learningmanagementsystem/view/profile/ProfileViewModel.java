package com.example.learningmanagementsystem.view.profile;

import android.app.Application;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.lifecycle.MutableLiveData;

import com.example.learningmanagementsystem.data.datasource.UserDataSource;
import com.example.learningmanagementsystem.data.repository.UserRepository;
import com.example.learningmanagementsystem.model.User;
import com.example.learningmanagementsystem.util.App;
import com.example.learningmanagementsystem.util.base.BaseViewModel;

public class ProfileViewModel extends BaseViewModel {
    private final MutableLiveData<User> mUserMutableLiveData = new MutableLiveData<>();
    public Double money = 0.0;

    @BindingAdapter("android:text")
    public static void setText(TextView view, Double value) {
        view.setText(String.valueOf(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Double getText(TextView view) {
        String text = view.getText().toString();
        return text.length() == 0 ? 0.0 : Double.valueOf(text);
    }


    public MutableLiveData<User> getUserMutableLiveData() {
        return mUserMutableLiveData;
    }

    public ProfileViewModel(@NonNull Application application) {
        super(application);
    }

    public void setUser(User user) {
        mUserMutableLiveData.postValue(user);
    }

    @Override
    protected void init() {

    }

    public void charge() {

        mRepository.user.recharge(App.getContext(), new UserDataSource.RechargeCallback() {
            @Override
            public void onSuccess(Double aDouble) {
                money = 0.0;
                mUserMutableLiveData.postValue(new User(UserRepository.ID, UserRepository.NAME, "", UserRepository.MONEY));
            }

            @Override
            public void onFailed(String errorMessage) {

            }
        }, UserRepository.ID, money);
    }
}
