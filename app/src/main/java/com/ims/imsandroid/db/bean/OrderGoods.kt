package com.ims.imsandroid.db.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.db.bean
 * @ClassName:      OrderGoods
 * @Description:     订单对应的商品
 * @Author:         Jsiony
 * @CreateDate:     2022/11/8 15:56
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/8 15:56
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@Entity
data class OrderGoods(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "ORDER_ID") var orderId: Long?, // 订单id
    @ColumnInfo(name = "GOODS_ID") var goodsId: String?, // 商品Id
    @ColumnInfo(name = "GOODS_NAME") var name: String?, // 商品名
    @ColumnInfo(name = "PRICE") var price: Double?, // 进价
    @ColumnInfo(name = "SPEC") var spec: String?,//规格
    @ColumnInfo(name = "SALE_PRICE") var salesPrice: Double?,//售价
    @ColumnInfo(name = "STOCK") var stock: Int?,//库存
    @ColumnInfo(name = "WEIGHT") var weight: Double?,//重量
    @ColumnInfo(name = "UNITS") var units: String?,//单位
    @ColumnInfo(name = "DESCRIPTION") var description: String?,//描述
    @ColumnInfo(name = "COVER_PIC") var coverPic: Byte?,//封面图
    @ColumnInfo(name = "QUANTITY") var quaniity: Double?,//数量
    @ColumnInfo(name = "REFUNDED_QTY") var refundedQty: Double?,//已退数量
    @ColumnInfo(name = "REFUNDED_FEE") var refundedFee: Double?,//已退金额
    @ColumnInfo(name = "TIME") var time: Date?, // 时间
)
