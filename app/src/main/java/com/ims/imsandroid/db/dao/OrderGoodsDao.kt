package com.ims.imsandroid.db.dao

import androidx.room.*
import com.ims.imsandroid.db.bean.OrderGoods

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.db.dao
 * @ClassName:      OrderGoodsDao
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/11/21 14:46
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/21 14:46
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@Dao
interface OrderGoodsDao : BaseDAO<OrderGoods> {
    @Query("SELECT * FROM ordergoods")
    fun getAll(): List<OrderGoods>

    @Query("SELECT * FROM orderGoods WHERE id IN (:orderGoodsIds)")
    fun loadAllByIds(orderGoodsIds: IntArray): List<OrderGoods>

    // onConflict 配置主键冲突处理
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrderGoods(vararg orderGoods: OrderGoods)

    @Delete
    override suspend fun delete(obj: OrderGoods)
}