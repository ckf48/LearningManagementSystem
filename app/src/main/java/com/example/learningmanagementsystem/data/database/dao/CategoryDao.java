package com.example.learningmanagementsystem.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.learningmanagementsystem.model.Category;

import java.util.List;

@Dao
public abstract class CategoryDao {
    @Query("select * from category")
    public abstract List<Category> selectAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(Category... categories);
}
