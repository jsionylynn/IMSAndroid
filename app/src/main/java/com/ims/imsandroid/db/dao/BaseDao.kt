package com.ims.imsandroid.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.ims.imsandroid.db.bean.User

/**
 *
 * @ProjectName:    compose
 * @Package:        com.ims.compose
 * @ClassName:      BaseDao
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/11/2 15:55
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/2 15:55
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */
interface BaseDAO<T> {

    @Insert
    suspend fun insert(obj: T)

    @Insert
    suspend fun insert(list: List<T>)

    @Update
    suspend fun update(obj: T)

    @Update
    suspend fun update(list: List<T>)

    @Delete
    suspend fun delete(obj: T)

    @Delete
    suspend fun delete(list: List<T>)
    @Delete
    suspend fun delete(obj: User)
}