package com.ims.imsandroid.db.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @ProjectName:    compose
 * @Package:        com.ims.compose.ui.bean
 * @ClassName:      Account
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/11/2 14:11
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/2 14:11
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@Entity(tableName = "user")
data class User(
    @PrimaryKey (autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "ACCOUNT") var account: String?,
    @ColumnInfo(name = "PASSWORD") var password: String?
)
