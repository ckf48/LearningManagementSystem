package com.example.learningmanagementsystem.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.learningmanagementsystem.model.Course;

import java.util.List;

@Dao
public abstract class CourseDao {
    @Query("select * from course where id == :id")
    public abstract Course queryCourse(Integer id);

    @Query("select * from course")
    public abstract LiveData<List<Course>> queryAllCourses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertCourses(Course... courses);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public abstract int updateCourses(Course... courses);

    @Query("delete from course")
    public abstract void deleteAll();
}
