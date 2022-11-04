package com.ims.imsandroid.utils

import android.widget.Toast
import com.ims.imsandroid.IMSApplication


fun String.showToast() = Toast.makeText(IMSApplication.context, this, Toast.LENGTH_SHORT).show()

fun String.showLongToast() = Toast.makeText(IMSApplication.context, this, Toast.LENGTH_LONG).show()

fun Int.showToast() = Toast.makeText(IMSApplication.context, this, Toast.LENGTH_SHORT).show()

fun Int.showLongToast() = Toast.makeText(IMSApplication.context, this, Toast.LENGTH_LONG).show()