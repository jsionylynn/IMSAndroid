package com.ims.imsandroid.repository

import com.ims.imsandroid.IMSApplication
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * 订单和商品数据
 * @description HomeRepository
 * @author jsiony
 * @date 2022/11/4 15:52
 */
@ViewModelScoped
class HomeRepository @Inject constructor() : BaseRepository() {

    /**
     * 获取订单
     */
    fun getOrders() = fire(Dispatchers.IO) {
        val orders = IMSApplication.db.orderDao().getAll()
        Result.success(orders)
//        if (news.code == CODE) Result.success(news)
//        else Result.failure(RuntimeException("getNews response code is ${news.code} msg is ${news.msg}"))
    }


    /**
     * 获取商品
     */
    fun getGoods() = fire(Dispatchers.IO) {
        val goods = IMSApplication.db.goodsDao().getAll()
        Result.success(goods)
//        if (news.code == CODE) Result.success(news)
//        else Result.failure(RuntimeException("getNews response code is ${news.code} msg is ${news.msg}"))
    }

//    /**
//     * 获取商品
//     */
//    fun getMilitaryNews() = fire(Dispatchers.IO) {
//        val news = NetworkRequest.getMilitaryNews()
//        if (news.code == CODE) Result.success(news)
//        else Result.failure(RuntimeException("getNews response code is ${news.code} msg is ${news.msg}"))
//    }
//
//    /**
//     * 统计
//     */
//    fun getTechnologyNews() = fire(Dispatchers.IO) {
//        val news = NetworkRequest.getTechnologyNews()
//        if (news.code == CODE) Result.success(news)
//        else Result.failure(RuntimeException("getNews response code is ${news.code} msg is ${news.msg}"))
//    }

}