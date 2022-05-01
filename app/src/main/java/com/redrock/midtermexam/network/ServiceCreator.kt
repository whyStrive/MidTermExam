package com.redrock.midtermexam.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author : why
 * @time : 2022/4/30 17:44
 * @email: why_wanghy@qq.com
 */

//创建Retrofit
object ServiceCreator {

    private const val BASE_URL = "http://redrock.udday.cn:8888/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //获取ApiService的动态代理对象
    //利用泛型实化，简化写法
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    inline fun <reified T> create(): T = create(T::class.java)
}
