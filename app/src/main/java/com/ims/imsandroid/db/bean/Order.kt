package com.ims.imsandroid.db.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.db.bean
 * @ClassName:      Order
 * @Description:     订单
 * @Author:         Jsiony
 * @CreateDate:     2022/11/8 15:44
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/8 15:44
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@Entity
data class Order(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "TIME") var time: Date?, // 时间
    @ColumnInfo(name = "STATUS") var status: String?, // 状态（订单状态(P-待拣货,F-交易完成）
    @ColumnInfo(name = "CREATE_BY") var createBy: String?,//创建人
    @ColumnInfo(name = "REMARK") var remark: String?,//备注
    @ColumnInfo(name = "SALE_PRICE") var salesPrice: Double?,//售价
    @ColumnInfo(name = "num") var num: String,//数量
    @ColumnInfo(name = "WEIGHT") var weight: Double?,//重量
    @ColumnInfo(name = "UNITS") var units: String?,//单位
    @ColumnInfo(name = "DESCRIPTION") var description: String?,//描述
    @ColumnInfo(name = "COVER_PIC") var coverPic: Byte?,//封面图
)
