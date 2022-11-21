package com.ims.imsandroid.db.dao

import androidx.room.*
import com.ims.imsandroid.db.bean.Order

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.db.dao
 * @ClassName:      OrderDao
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/11/21 14:42
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/21 14:42
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@Dao
interface OrderDao : BaseDAO<Order> {
    @Query("SELECT * FROM [order]")
    fun getAll(): List<Order>

    @Query("SELECT * FROM [order] WHERE id IN (:orderIds)")
    fun loadAllByIds(orderIds: IntArray): List<Order>

    // onConflict 配置主键冲突处理
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrder(vararg order: Order)

    @Delete
    override suspend fun delete(obj: Order)
}