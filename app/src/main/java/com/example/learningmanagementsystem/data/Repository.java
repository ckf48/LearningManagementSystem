package com.example.learningmanagementsystem.data;

import android.content.Context;

import com.example.learningmanagementsystem.data.database.AppDatabase;
import com.example.learningmanagementsystem.data.repository.CategoryRepository;
import com.example.learningmanagementsystem.data.repository.CourseRepository;
import com.example.learningmanagementsystem.data.repository.LessonRepository;
import com.example.learningmanagementsystem.data.repository.PurchaseRepository;
import com.example.learningmanagementsystem.data.repository.UserRepository;


public class Repository{
    public final CategoryRepository category;
    public final CourseRepository course;
    public final LessonRepository lesson;
    public final UserRepository user;
    public final PurchaseRepository purchase;

    public Repository(Context application) {
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        category = new CategoryRepository(appDatabase);
        course = new CourseRepository(appDatabase);
        lesson = new LessonRepository(appDatabase);
        user = new UserRepository(appDatabase);
        purchase = new PurchaseRepository(appDatabase);
    }
}
