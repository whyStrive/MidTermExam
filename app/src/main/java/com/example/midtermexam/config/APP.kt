package com.example.midtermexam.config

import android.app.Application
import android.content.Context

/**
 * @author : why
 * @time : 2022/4/30 09:49
 * @email: why_wanghy@qq.com
 */
class APP : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}