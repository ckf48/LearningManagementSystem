package com.example.learningmanagementsystem.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.learningmanagementsystem.model.Lesson;

import java.util.List;

@Dao
public abstract class LessonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(Lesson... lessons);

    @Query("select * from lesson where id == :id")
    public abstract Lesson select(Integer id);

    @Query("select * from lesson")
    public abstract List<Lesson> selectAll();

    @Query("select * from lesson where cid == :cid")
    public abstract List<Lesson> selectByCourse(Integer cid);
}
