package com.ims.imsandroid.ui.page.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.gson.Gson
import com.ims.imsandroid.R
import com.ims.imsandroid.db.bean.Order
import com.ims.imsandroid.viewmodel.HomeViewModel

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.ui.page.home
 * @ClassName:      OrderItem
 * @Description:     订单
 * @Author:         Jsiony
 * @CreateDate:     2022/11/8 15:36
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/8 15:36
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OrderItem(mNavController: NavHostController, viewModel: HomeViewModel) {
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier
            .padding(8.dp)
    ) {


        var orders: List<Order>? = viewModel.orders.value?.getOrNull()
        if (orders.isNullOrEmpty()) {
            return@LazyColumn
        }
        items(orders) { order ->
            Log.d("TAG", "ShowNewsList: ${Gson().toJson(orders)}")
            Row(
                modifier = Modifier
//                .clickable {
//                    val encodedUrl = URLEncoder.encode(order.name, StandardCharsets.UTF_8.toString())
//                    mNavController.navigate("${PageConstant.WEB_VIEW_PAGE}/${new.title}/$encodedUrl")
//                }
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(order.coverPic)
                        .error(R.drawable.ic_launcher_background)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    modifier = Modifier
                        .width(120.dp)
                        .height(80.dp),
                    contentScale = ContentScale.FillBounds
                )
                Column(modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp)) {
                    order.stock?.let {
                        Text(
                            text = it.toString(),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp
                        )
                    }
                    Row(modifier = Modifier.padding(0.dp, 10.dp)) {
                        order.units?.let { Text(text = it, fontSize = 12.sp) }
                        Text(
                            text = order.salesPrice.toString(),
                            fontSize = 12.sp,
                            modifier = Modifier.padding(8.dp, 0.dp)
                        )
                    }
                }
            }
            Divider(
                modifier = Modifier.padding(horizontal = 8.dp),
                color = colorResource(id = R.color.black).copy(alpha = 0.08f)
            )
        }
    }


}
