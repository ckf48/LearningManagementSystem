package com.example.learningmanagementsystem.view.home.category;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.learningmanagementsystem.data.datasource.CategoryDataSource;
import com.example.learningmanagementsystem.model.Category;
import com.example.learningmanagementsystem.util.App;
import com.example.learningmanagementsystem.util.base.BaseViewModel;

import java.util.List;

public class CategoryViewModel extends BaseViewModel {
    private final MutableLiveData<List<Category>> categoryLiveData;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        categoryLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Category>> getCategoryLiveData() {
        return categoryLiveData;
    }

    @Override
    protected void init() {
    }

    public void refresh() {
        mRepository.category.getCategories(App.getContext(), new CategoryDataSource.GetCategoriesCallback() {
            @Override
            public void onSuccess(List<Category> list) {
                categoryLiveData.postValue(list);
            }

            @Override
            public void onFailed(String errorMessage) {
                categoryLiveData.postValue(null);
            }
        });
    }
}
