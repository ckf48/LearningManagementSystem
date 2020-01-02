package com.example.learningmanagementsystem.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.learningmanagementsystem.model.Type;

import java.util.List;

@Dao
public abstract class TypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(Type... types);

    @Query("select course from type where category == :category")
    public abstract List<Integer> selectByCategory(Integer category);
}
