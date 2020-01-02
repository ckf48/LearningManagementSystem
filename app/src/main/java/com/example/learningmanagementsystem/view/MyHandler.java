package com.example.learningmanagementsystem.view;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.learningmanagementsystem.MobileNavigationDirections;
import com.example.learningmanagementsystem.model.LessonBriefInfo;
import com.example.learningmanagementsystem.view.home.HomeFragmentDirections;

public class MyHandler {
    public static int cid;

    public void navigateToCourse(View view, int cid) {
        //TODO
        NavController navController = Navigation.findNavController(view);
        MobileNavigationDirections.ActionGlobalNavCourse action = MobileNavigationDirections.actionGlobalNavCourse(cid);
        navController.navigate(action);
    }

    public void navigateToLesson(View view, LessonBriefInfo lesson) {

    }

    public void navigateToCategoryDetail(View view, int id) {
        NavController navController = Navigation.findNavController(view);
        HomeFragmentDirections.ActionNavHomeToCategoryDetailFragment action = HomeFragmentDirections.actionNavHomeToCategoryDetailFragment(id);
        navController.navigate(action);
    }
}
