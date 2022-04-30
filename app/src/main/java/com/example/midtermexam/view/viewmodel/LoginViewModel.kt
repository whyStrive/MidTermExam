package com.example.midtermexam.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.midtermexam.Repository
import com.example.midtermexam.model.LoginModel
import com.example.midtermexam.model.RegisterModel

/**
 * @author : why
 * @time : 2022/4/30 21:40
 * @email: why_wanghy@qq.com
 */
class LoginViewModel : ViewModel() {

    //登录信息
    suspend fun getLoginResult(phoneNum: Long): LoginModel =
        Repository.getLoginResult(phoneNum)

    //注册结果
    suspend fun getRegisterResult(phoneNum: Long, name: String): RegisterModel =
        Repository.getRegisterResult(phoneNum, name)
}