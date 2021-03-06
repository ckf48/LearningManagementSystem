package com.example.learningmanagementsystem.model;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

import lombok.Data;

@Data
@Entity
public class LessonBriefInfo {
    public String title;

    public Date time;

    @PrimaryKey
    @NonNull
    public Integer id;

    public Integer cid;

    public LessonBriefInfo(String title, Date time, Integer id, Integer cid) {
        this.title = title;
        this.time = time;
        this.id = id;
        this.cid = cid;
    }

    @BindingAdapter("android:text")
    public static void getText(TextView view, Date date) {
        view.setText(date.toString());
    }
}
