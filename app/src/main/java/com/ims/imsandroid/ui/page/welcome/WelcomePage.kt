package com.ims.imsandroid.ui.page.welcome

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import com.ims.imsandroid.R
import com.ims.imsandroid.ui.page.PageConstant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.ui.page
 * @ClassName:      Welcome
 * @Description:     欢迎页
 * @Author:         Jsiony
 * @CreateDate:     2022/11/4 9:28
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/4 9:28
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@SuppressLint("ComposableNaming")
@Composable
fun welcome(lifecycleScope: LifecycleCoroutineScope,mNavController: NavHostController) {
    val num = remember { mutableStateOf("") }
    Column {
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(R.color.black))
        Text(
            text = "欢迎来到IMS\n 有问题找XYL",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(0.dp)
                .width(0.dp)
        )

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = num.value,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.purple_700),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }

    if(mNavController.currentDestination?.route.equals(PageConstant.WELCOME_PAGE)) {
        toLogin(num , lifecycleScope, mNavController)
    }
}
fun toLogin(num: MutableState<String>, lifecycleScope: LifecycleCoroutineScope, mNavController: NavHostController) {

//    val job = countDownCoroutines(5, lifecycleScope,
//        onTick = { second ->
//            num.value = second.toString()
//        }, onStart = {
//        }, onFinish = {
//            mNavController.navigate(PageConstant.LOGIN_PAGE)
//        })

    val TotalTime : Long = 5*1000 //总时长 2小时
    object : CountDownTimer(TotalTime,1000){//1000ms运行一次onTick里面的方法
    override fun onFinish() {
        mNavController.navigate(PageConstant.LOGIN_PAGE)
    }

        override fun onTick(millisUntilFinished: Long) {
            num.value = (millisUntilFinished/1000).toString()
        }
    }.start()

}

fun countDownCoroutines(
    total: Int,
    scope: CoroutineScope,
    onTick: (Int) -> Unit,
    onStart: (() -> Unit)? = null,
    onFinish: (() -> Unit)? = null,
): Job {
    return flow {
        for (i in total downTo 0) {
            emit(i)
            delay(1000)
        }
    }.flowOn(Dispatchers.Main)
        .onStart { onStart?.invoke() }
        .onCompletion { onFinish?.invoke() }
        .onEach { onTick.invoke(it) }
        .launchIn(scope)
}





@Preview
@Composable
fun showWelcome() {
//    welcome(lifecycleScope)
}