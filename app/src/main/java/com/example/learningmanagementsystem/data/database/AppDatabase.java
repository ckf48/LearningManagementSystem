package com.example.learningmanagementsystem.data.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.learningmanagementsystem.data.database.dao.CategoryDao;
import com.example.learningmanagementsystem.data.database.dao.CourseBriefInfoDao;
import com.example.learningmanagementsystem.data.database.dao.CourseDao;
import com.example.learningmanagementsystem.data.database.dao.LessonDao;
import com.example.learningmanagementsystem.data.database.dao.PurchaseDao;
import com.example.learningmanagementsystem.data.database.dao.TypeDao;
import com.example.learningmanagementsystem.data.database.dao.UserDao;
import com.example.learningmanagementsystem.data.database.datasource.LocalPurchaseDataSource;
import com.example.learningmanagementsystem.model.Category;
import com.example.learningmanagementsystem.model.Course;
import com.example.learningmanagementsystem.model.CourseBriefInfo;
import com.example.learningmanagementsystem.model.Lesson;
import com.example.learningmanagementsystem.model.Purchase;
import com.example.learningmanagementsystem.model.Type;
import com.example.learningmanagementsystem.model.User;

@Database(entities = {User.class, Course.class, CourseBriefInfo.class, Lesson.class, Category.class, Type.class, Purchase.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;
    private static Callback sCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new LocalPurchaseDataSource(INSTANCE).deleteAll();
//            new CourseAsyncTasks.populateCourseDbTask(INSTANCE).execute();
//            new UserAsyncTasks.populateUserDbTask(INSTANCE).execute();
        }
    };

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "app_database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .addCallback(sCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract UserDao userDao();

    public abstract CourseDao courseDao();

    public abstract CourseBriefInfoDao courseBasicMessageDao();

    public abstract LessonDao lessonDao();

    public abstract CategoryDao categoryDao();

    public abstract TypeDao typeDao();

    public abstract PurchaseDao purchaseDao();
}
