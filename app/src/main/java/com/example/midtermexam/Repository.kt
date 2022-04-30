package com.example.midtermexam

import android.util.Log
import com.example.midtermexam.model.LoginModel
import com.example.midtermexam.network.ApiService
import com.example.midtermexam.network.ServiceCreator
import com.example.midtermexam.util.getResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author : why
 * @time : 2022/4/30 17:41
 * @email: why_wanghy@qq.com
 */
object Repository {

    private val api = ServiceCreator.create<ApiService>()

    //登录
    suspend fun getLoginResult(phoneNum: Long): LoginModel =
        withContext(Dispatchers.IO) {
            api.login(phoneNum).getResponse()
        }

    //注册
    suspend fun getRegisterResult(phoneNum: Long, name: String) =
        withContext(Dispatchers.IO) {
            api.register(phoneNum, name).getResponse()
        }
}