package com.ims.imsandroid.ui.page.welcome

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
import com.ims.imsandroid.R
import java.util.*

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

@Composable
fun welcome() {
    var num by remember { mutableStateOf(0) }
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
            modifier = Modifier.align(Alignment.CenterHorizontally).height(0.dp).width(0.dp)
        )

        Text(
            text = "$num",
            fontSize = 4.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.purple_700),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }

    toLogin(num)
}


fun toLogin(num: Int) {
    Timer().schedule(object : TimerTask() {
        override fun run() {
            num + 1
        }
    }, 4000)
}

@Preview
@Composable
fun showWelcome() {
    welcome()
}