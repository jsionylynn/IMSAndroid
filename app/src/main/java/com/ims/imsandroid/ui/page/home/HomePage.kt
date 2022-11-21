package com.ims.imsandroid.ui.page.home

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.Sick
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ims.imsandroid.ui.bottom.BottomBarView
import com.ims.imsandroid.R
import com.ims.imsandroid.ui.page.PageConstant
import com.ims.imsandroid.ui.page.PageConstant.GOODS_ITEM
import com.ims.imsandroid.ui.page.PageConstant.ORDER_ITEM
import com.ims.imsandroid.ui.page.PageConstant.STATISTICS_ITEM
import com.ims.imsandroid.viewmodel.HomeViewModel

/**
 *
 * @ProjectName:    IMSAndroid
 * @Package:        com.ims.imsandroid.ui.page.home
 * @ClassName:      HomePage
 * @Description:     java类作用描述
 * @Author:         Jsiony
 * @CreateDate:     2022/11/4 14:36
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/4 14:36
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomePage(mNavController: NavHostController, viewModel: HomeViewModel){
    val navController = rememberAnimatedNavController()
    var changeItem : LiveData<String>  = MutableLiveData()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            //顶部应用栏
            val drawerState = scaffoldState.drawerState
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colors.onSecondary,
                        overflow = TextOverflow.Ellipsis, //超出省略
                        maxLines = 1, //单行显示
                        textAlign = TextAlign.Center
                    )
                },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        scope.launch {
//                            if (drawerState.isClosed) drawerState.open() else drawerState.close()
//                        }
//                    }) {
//                        Icon(Icons.Default.Menu, contentDescription = "Menu")
//                    }
//                },
                actions = {
                    IconButton(onClick = {
                        mNavController.navigate(PageConstant.ADD_ORDER)
                    }) {
                        Icon(Icons.Default.Add, contentDescription = "添加订单")
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize(),
//        drawerContent = { DrawerView() },
        bottomBar = {
            BottomBarView(navController)
        }
    ) {
        AnimatedNavHost(
            navController = navController,
            startDestination = ORDER_ITEM,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(500)
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(500)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(500)
                )
            }
        ) {
            composable(ORDER_ITEM) {
                OrderItem(mNavController, viewModel)
            }
            composable(GOODS_ITEM) {
                OrderItem(mNavController, viewModel)
            }
            composable(STATISTICS_ITEM) {
                OrderItem(mNavController, viewModel)
            }
        }
    }
}