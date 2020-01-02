package com.example.learningmanagementsystem.view.calendar;

import android.view.View;

import com.example.learningmanagementsystem.R;
import com.example.learningmanagementsystem.util.base.BaseFragment;

public class CalendarFragment extends BaseFragment {

    public static CalendarFragment newInstance() {
        return new CalendarFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.calendar_fragment;
    }

    @Override
    protected void initView(View root) {

    }

}
