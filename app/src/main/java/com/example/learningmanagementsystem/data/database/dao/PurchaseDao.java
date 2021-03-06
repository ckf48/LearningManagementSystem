package com.example.learningmanagementsystem.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.learningmanagementsystem.model.Purchase;

import java.util.List;

@Dao
public abstract class PurchaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(Purchase... purchases);

    @Query("select * from purchase where uid == :uid and cid == :cid")
    public abstract Purchase didIBought(Integer uid, Integer cid);

    @Query("delete from purchase")
    public abstract void deleteAll();

    @Query("select cid from purchase where uid == :uid")
    public abstract List<Integer> selectByUid(Integer uid);
}
