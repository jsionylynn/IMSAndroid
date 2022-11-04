package com.ims.imsandroid.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ims.imsandroid.R

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
    Column {
        Modifier.fillMaxSize()
        Modifier.background(Color(R.color.white))
        Text(
            text = "欢迎来到IMS\n 有问题找XYL",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun showWelcome() {
    welcome()
}