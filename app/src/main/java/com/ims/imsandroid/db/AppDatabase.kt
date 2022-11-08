package com.ims.imsandroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ims.imsandroid.db.bean.Goods
import com.ims.imsandroid.db.bean.User
import com.ims.imsandroid.db.dao.GoodsDao
import com.ims.imsandroid.db.dao.UserDao

/**
 * 数据库
 * @description AppDatabase
 * @author jsiony
 * @date 2022/11/4 14:46
 */
@Database(entities = [User::class,Goods::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun goodsDao(): GoodsDao
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