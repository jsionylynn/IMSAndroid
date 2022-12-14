package com.ims.imsandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ims.imsandroid.repository.HomeRepository
import com.ims.imsandroid.ui.page.PageConstant.ADD_GOODS
import com.ims.imsandroid.ui.page.PageConstant.ADD_ORDER
import com.ims.imsandroid.ui.page.PageConstant.HOME_PAGE
import com.ims.imsandroid.ui.page.PageConstant.LOGIN_PAGE
import com.ims.imsandroid.ui.page.PageConstant.WELCOME_PAGE
import com.ims.imsandroid.ui.page.home.HomePage
import com.ims.imsandroid.ui.page.login.login
import com.ims.imsandroid.ui.page.order.AddOrderPage
import com.ims.imsandroid.ui.page.welcome.welcome
import com.ims.imsandroid.ui.theme.IMSAndroidTheme
import com.ims.imsandroid.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMSAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberAnimatedNavController()
                    val homeViewModel: HomeViewModel = viewModel(
                        factory = HomeViewModel.provideFactory(HomeRepository())
                    )
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = WELCOME_PAGE,
                        //????????????
                        enterTransition = {
                            slideInHorizontally(
                                initialOffsetX = { fullWidth -> fullWidth },
                                animationSpec = tween(500)
                            )
                        },
                        //????????????
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
                        //?????????
                        composable(WELCOME_PAGE) {
                            welcome(lifecycleScope, navController)
                        }
                        //?????????
                        composable(LOGIN_PAGE) {
                            if(navController.currentDestination?.route.equals(LOGIN_PAGE)) {
                                login(navController)
                            }
                        }

                        composable(HOME_PAGE) {
                            HomePage(navController, homeViewModel)
                        }

                        //????????????
                        composable(ADD_ORDER) {
                            AddOrderPage(navController, homeViewModel)
                        }

                        //????????????
                        composable(ADD_GOODS) {
                            AddOrderPage(navController, homeViewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IMSAndroidTheme {
        Greeting("Android")
    }
}