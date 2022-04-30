package com.example.midtermexam.network

import com.example.midtermexam.model.LoginModel
import com.example.midtermexam.model.RegisterModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author : why
 * @time : 2022/4/30 17:36
 * @email: why_wanghy@qq.com
 */

//Retrofit的
interface ApiService {

    //注册
    @FormUrlEncoded
    @POST("user/register")
    fun register(
        @Field("phone_number") phoneNum: Long,
        @Field("name") name: String
    ): Call<RegisterModel>

    //登录
    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("phone_number") phoneNum: Long): Call<LoginModel>


}