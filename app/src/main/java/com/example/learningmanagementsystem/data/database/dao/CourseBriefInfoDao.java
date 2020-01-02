package com.example.learningmanagementsystem.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.learningmanagementsystem.model.CourseBriefInfo;

import java.util.List;

@Dao
public abstract class CourseBriefInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(List<CourseBriefInfo> messages);

    @Query("select * from CourseBriefInfo")
    public abstract List<CourseBriefInfo> queryAll();

    @Query("select * from CourseBriefInfo where id in (:ids)")
    public abstract List<CourseBriefInfo> queryById(List<Integer> ids);
}
