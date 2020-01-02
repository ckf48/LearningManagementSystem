package com.example.learningmanagementsystem.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.learningmanagementsystem.model.User;

import java.util.List;

@Dao
public abstract class UserDao {
    @Query("select * from user where id == :id ")
    public abstract User queryUser(Integer id);

    @Query("select * from user")
    public abstract LiveData<List<User>> queryAllUser();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void insertUsers(User... users);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public abstract int updateUsers(User... users);

    @Query("delete from user")
    public abstract void deleteAll();
}
