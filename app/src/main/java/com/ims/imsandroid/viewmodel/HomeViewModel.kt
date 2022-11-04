package com.ims.imsandroid.viewmodel

import androidx.lifecycle.ViewModel
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

    val result = repository.getOrder()

}