package com.ims.imsandroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ims.imsandroid.db.bean.*
import com.ims.imsandroid.db.dao.*

/**
 * 数据库
 * @description AppDatabase
 * @author jsiony
 * @date 2022/11/4 14:46
 */
@Database(entities = [User::class, Goods::class,Order::class,OrderGoods::class, Stock::class], version = 1, exportSchema = false)
@TypeConverters(ConvertersDate::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun goodsDao(): GoodsDao
    abstract fun orderDao(): OrderDao
    abstract fun orderGoodsDao(): OrderGoodsDao
    abstract fun stock(): StockDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        private const val DATABASE_NAME = "ims.db"

        /**
         * 版本升级迁移到2 新增收藏新闻表
         */
//        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL(
//                    "CREATE TABLE `collectionnews` " +
//                            "(uid INTEGER, " +
//                            "picUrl TEXT, " +
//                            "ctime TEXT, " +
//                            "description TEXT, " +
//                            "id TEXT, " +
//                            "source TEXT, " +
//                            "title TEXT, " +
//                            "url TEXT, " +
//                            "PRIMARY KEY(`uid`))"
//                )
//            }
//        }


        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
//                    .addMigrations(MIGRATION_1_2)
                    .build()
                    .also { instance = it }
            }
        }
    }
}