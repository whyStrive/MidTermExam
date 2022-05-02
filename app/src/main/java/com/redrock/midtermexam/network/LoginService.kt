package com.redrock.midtermexam.network

import com.redrock.midtermexam.model.LoginModel
import com.redrock.midtermexam.model.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author : why
 * @time : 2022/5/2 11:21
 * @email: why_wanghy@qq.com
 */
interface LoginService {

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