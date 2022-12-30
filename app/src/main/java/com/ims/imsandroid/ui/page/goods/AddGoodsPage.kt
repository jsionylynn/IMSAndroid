package com.ims.imsandroid.ui.page.goods

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ims.imsandroid.IMSApplication
import com.ims.imsandroid.db.AppDatabase
import com.ims.imsandroid.db.bean.Goods
import com.ims.imsandroid.db.bean.Order
import com.ims.imsandroid.entity.OrderEntity
import com.ims.imsandroid.ui.page.PageConstant
import com.ims.imsandroid.utils.showLongToast
import com.ims.imsandroid.viewmodel.HomeViewModel
import com.tencent.mmkv.MMKV
import java.util.*

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.ui.page.goods
 * @ClassName:      AddGoodsPage
 * @Description:     添加商品
 * @Author:         Jsiony
 * @CreateDate:     2022/12/27 13:59
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/12/27 13:59
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */
@Composable
fun AddGoodsPage(mNavController: NavHostController, viewModel: HomeViewModel) {


    val context: Context = IMSApplication.context
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {

        Text(
            text = "商品名称",
            fontSize = 15.sp,
            modifier = Modifier.offset(5.dp)
        )

        TextField("商品名称", onValueChange = {
            number = it
        })

        Text(
            text = "价格",
            fontSize = 15.sp,
            modifier = Modifier.offset(5.dp)
        )

        TextField("价格", onValueChange = {
            number = it
        })

        Text(
            text = "商品名称",
            fontSize = 15.sp,
            modifier = Modifier.offset(5.dp)
        )

        TextField("商品名称", onValueChange = {
            number = it
        })

        Text(
            text = "商品名称",
            fontSize = 15.sp,
            modifier = Modifier.offset(5.dp)
        )

        TextField("商品名称", onValueChange = {
            number = it
        })

        Text(
            text = "商品名称",
            fontSize = 15.sp,
            modifier = Modifier.offset(5.dp)
        )

        TextField("商品名称", onValueChange = {
            number = it
        })

        Text(
            text = "商品名称",
            fontSize = 15.sp,
            modifier = Modifier.offset(5.dp)
        )

        TextField("商品名称", onValueChange = {
            number = it
        })

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = { addGoods(context, mNavController)},
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "下单")
        }
    }
}

/**
 * 下单
 */
fun addGoods(context: Context,  mNavController: NavHostController) {
    if (checkedOrderEntity.isEmpty()) {
        "请选择商品下单".showLongToast()
        return
    }

    "下单成功".showLongToast()
    mNavController.navigate(PageConstant.HOME_PAGE)
    for (order in checkedOrderEntity){
        AppDatabase.getInstance(context).orderDao().insertOrder(order.order)
    }

}
