package com.ims.imsandroid.utils


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.ims.imsandroid.ui.page.PageConstant.GOODS_ITEM
import com.ims.imsandroid.ui.page.PageConstant.ORDER_ITEM
import com.ims.imsandroid.ui.page.PageConstant.STATISTICS_ITEM

/**
 * 定义路线名称，底部标题和图标
 */
sealed class BottomItemScreen(val route: String, val title: String, val icon: ImageVector) {
    object ORDER : BottomItemScreen(ORDER_ITEM, "订单", Icons.Default.Reorder)
    object GOODS : BottomItemScreen(GOODS_ITEM, "商品", Icons.Default.GppGood)
    object STATISTICS : BottomItemScreen(STATISTICS_ITEM, "统计", Icons.Default.EvStation)
}
