package com.ims.imsandroid.entity

import com.ims.imsandroid.db.bean.Order

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.entity
 * @ClassName:      OrderEntity
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/12/9 10:32
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/12/9 10:32
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */
data class OrderEntity(
    var order: Order,
    var isChecked: Boolean
)
