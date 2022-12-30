package com.ims.imsandroid.ui.page.order

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
 * @Package:        com.ims.imsandroid.ui.page.order
 * @ClassName:      AddOrder
 * @Description:     添加订单
 * @Author:         Jsiony
 * @CreateDate:     2022/12/7 10:05
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/12/7 10:05
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

private val checkedOrderEntity = mutableStateListOf<OrderEntity>()

@Composable
fun AddOrderPage(mNavController: NavHostController, viewModel: HomeViewModel) {
    val context: Context = IMSApplication.context
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
//        DropdownMenu(expanded = true, onDismissRequest = {
//
//        }, modifier = Modifier.width(100.dp)) {
//            viewModel.goods.value?.getOrNull()?.forEach {
//                DropdownMenuItem(onClick = {
//                    Log.e("tag", "吃：$it")
//                }) {
//                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
//                    goodsId = it.id.toString()
//                    it.name?.let { it1 -> Text(text = it1, modifier = Modifier.padding(start = 10.dp)) }
//                }
//            }
//        }

        viewModel.goods.value?.getOrNull()?.forEachIndexed { i, goods ->
            CheckBoxItem(i, goods)
        }

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = { tradingOrder(context, checkedOrderEntity ,mNavController)},
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
fun tradingOrder(context: Context, checkedOrderEntity: SnapshotStateList<OrderEntity>, mNavController: NavHostController) {
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


@Composable
private fun CheckBoxItem(position: Int, goods: Goods) {
    var checked by remember {
        mutableStateOf(false)
    }

    var number by remember {
        mutableStateOf("0")
    }
    Checkbox(
        checked = checked,                      //是否选中
        onCheckedChange = {
            checked = it
            if (number.isBlank()) {
                "请输入数量".showLongToast()
            } else {
                if (it) {
                    checkedOrderEntity.add(OrderEntity(order = Order(
                        time = Date(),
                        status = "P",
                        createBy = MMKV.defaultMMKV().decodeString("NAME"),
                        remark = "",
                        salesPrice = goods.salesPrice,
                        num = number,
                        weight = goods.weight,
                        units = goods.units,
                        description = goods.description,
                        coverPic = goods.coverPic),isChecked = checked))

                }
            }
        },                                          //变化后的回调
        modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 20.dp),        //修饰符
        enabled = true,                             //是否启用
//        colors = CheckboxDefaults.colors(
//            checkedColor = commonBlue,               //选中时将用于边框和框的颜色
//            uncheckedColor = black,                  //未选中时将用于边框的颜色
//            checkmarkColor = red1,                   //选中时将用于复选标记的颜色
//            disabledColor = green1,                  //禁用时将用于框和边框的颜色
//            disabledIndeterminateColor = yellow1     //禁用且处于不确定状态时，将用于三态复选框（开，关，不确定）中边框的颜色
//        )
    )
    Text(
        text = goods.name.toString(),
        fontSize = 15.sp,
        modifier = Modifier.offset(5.dp)
    )

    TextField(goods.units.toString(), onValueChange = {
        number = it
    })
}