package com.ims.imsandroid.ui.page.login

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ims.imsandroid.IMSApplication
import com.ims.imsandroid.R
import com.ims.imsandroid.db.AppDatabase
import com.ims.imsandroid.utils.showLongToast

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.ui.page
 * @ClassName:      Login页面
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/11/3 16:13
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/3 16:13
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@Composable
fun login() {
    val context: Context = IMSApplication.context
    var account by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "IMS",
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = account,
            onValueChange = { account = it },
            label = { Text(text = stringResource(R.string.acc_name)) },
            placeholder = {
                Text(
                    text = stringResource(R.string.acc_hint),
                    color = colorResource(R.color.white)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            ),
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it

            },
            label = { Text(text = stringResource(R.string.pw_name)) },
            placeholder = {
                Text(
                    text = stringResource(R.string.pw_hint),
                    color = colorResource(R.color.white)
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { login(context, account, password) }),
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(60.dp))
        Button(
            onClick = { login(context, account, password) },
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "登录")
        }

    }


//    Spacer(modifier = Modifier.width(20.dp))
//    Spacer(modifier = Modifier.height(20.dp))
//    Box{
//        Text(text = msg.author)
//        Text(text = msg.body)
//    }
}

fun login(context: Context, acc: String, pws: String) {
//    val all = AppDatabase.getInstance(context).userDao().getAll()
//    Log.e("Lyn", "login: $all")
    if (acc.isBlank()) {
        "请输入账号".showLongToast()
        return
    }
    if (pws.isBlank()) {
        "请输入密码".showLongToast()
        return
    }

    val user = AppDatabase.getInstance(context).userDao().findByName(acc)
    if (!user.account.equals(acc)) {
        "账号错误".showLongToast()
        return
    }
    if (!user.password.equals(pws)) {
        "密码错误".showLongToast()
        return
    }
    "登录成功".showLongToast()
    //    AppDatabase.getInstance(context).userDao().insertUsers(User(account = acc, password = pws))
}


@Preview
@Composable
fun PreviewMessageCard() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        login()
    }
}