package com.ims.imsandroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ims.imsandroid.db.bean.User
import com.ims.imsandroid.db.dao.UserDao

/**
 * 数据库
 * @description AppDatabase
 * @author llw
 * @date 2022/4/4 1:33
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        private const val DATABASE_NAME = "ims.db"

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build()
                    .also { instance = it }
            }
        }
    }
}