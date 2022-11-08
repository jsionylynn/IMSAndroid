package com.ims.imsandroid.db.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.db.bean
 * @ClassName:      Goods
 * @Description:     商品
 * @Author:         Jsiony
 * @CreateDate:     2022/11/7 9:29
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/7 9:29
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@Entity
data class Goods(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "GOODS_NAME") var name: String?, // 商品名
    @ColumnInfo(name = "PRICE") var price: Double?, // 进价
    @ColumnInfo(name = "SPEC") var spec: String?,//规格
    @ColumnInfo(name = "SALE_PRICE") var salesPrice: Double?,//售价
    @ColumnInfo(name = "STOCK") var stock: Int?,//库存
    @ColumnInfo(name = "WEIGHT") var weight: Double?,//重量
    @ColumnInfo(name = "UNITS") var units: String?,//单位
    @ColumnInfo(name = "DESCRIPTION") var description: String?,//描述
    @ColumnInfo(name = "COVER_PIC") var coverPic: Byte?,//封面图
    @ColumnInfo(name = "STATUS") var status: String?,//状态(N-新建,O-上架,F-下架,D-删除)
)
