package com.ims.imsandroid.db.dao

import androidx.room.TypeConverter
import java.util.*

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.db.dao
 * @ClassName:      ConvertersDate
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/11/21 16:12
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/21 16:12
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */
class ConvertersDate {
    @TypeConverter
    fun timestampToDate(value: Long?) = value?.let { Date(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?) = date?.time
}