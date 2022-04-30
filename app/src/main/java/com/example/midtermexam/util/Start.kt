package com.example.midtermexam.util

import android.app.Activity
import android.content.Intent

/**
 * @author : why
 * @time : 2022/4/30 14:20
 * @email: why_wanghy@qq.com
 *
 * 启动activity方法的封装
 */


//带参数的启动
inline fun <reified T : Activity> Activity.startWithData(block: Intent.() -> Unit) {
    val intent = Intent(this, T::class.java).apply {
        block()
    }
    startActivity(intent)
}

//不带参数的启动
inline fun <reified T : Activity> Activity.start() {
    startActivity(Intent(this,T::class.java))
}