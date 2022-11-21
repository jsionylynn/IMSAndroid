package com.ims.imsandroid.db.dao

import androidx.room.*
import com.ims.imsandroid.db.bean.Stock

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.db.dao
 * @ClassName:      StockDao
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/11/21 14:48
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/21 14:48
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */
@Dao
interface StockDao  : BaseDAO<Stock> {
    @Query("SELECT * FROM stock")
    fun getAll(): List<Stock>

    @Query("SELECT * FROM stock WHERE id IN (:stockIds)")
    fun loadAllByIds(stockIds: IntArray): List<Stock>

    // onConflict 配置主键冲突处理
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStock(vararg stock: Stock)

    @Delete
    override suspend fun delete(obj: Stock)
}