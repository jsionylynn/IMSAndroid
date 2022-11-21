package com.ims.imsandroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ims.imsandroid.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * HomeViewModel
 * @author jsiony
 * @date 2022/11/4 14:41
 */
@HiltViewModel
class HomeViewModel @Inject constructor(repository: HomeRepository) : ViewModel() {
    val orders = repository.getOrders()

    companion object {
        fun provideFactory(
            postsRepository: HomeRepository,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(postsRepository) as T
            }
        }
    }
}