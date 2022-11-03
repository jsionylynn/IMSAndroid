package com.ims.imsandroid

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.ims.imsandroid.db.AppDatabase
import dagger.hilt.android.HiltAndroidApp

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid
 * @ClassName:      IMSApplictaion
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/11/3 16:07
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/3 16:07
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */
@HiltAndroidApp
class IMSApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        lateinit var db: AppDatabase
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: IMSApplication
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        db = AppDatabase.getInstance(context)
        instance = this
    }
}