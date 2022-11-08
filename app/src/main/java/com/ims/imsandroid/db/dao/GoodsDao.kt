package com.ims.imsandroid.db.dao

import androidx.room.*
import com.ims.imsandroid.db.bean.Goods
import com.ims.imsandroid.db.bean.User

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.db.dao
 * @ClassName:      GoodsDao
 * @Description:
 * @Author:         Jsiony
 * @CreateDate:     2022/11/7 10:39
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/7 10:39
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@Dao
interface GoodsDao : BaseDAO<Goods> {
    @Query("SELECT * FROM goods")
    fun getAll(): List<Goods>

    @Query("SELECT * FROM goods WHERE id IN (:goodsIds)")
    fun loadAllByIds(goodsIds: IntArray): List<Goods>

    // onConflict 配置主键冲突处理
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoods(vararg goods: Goods)

    @Delete
    override suspend fun delete(obj: Goods)
}