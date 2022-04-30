package com.example.midtermexam.util

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @author : why
 * @time : 2022/4/30 20:34
 * @email: why_wanghy@qq.com
 *
 * 参考郭霖的写法，封装一个利用retrofit进行网络请求的Call的扩展函数
 */

suspend fun <T> Call<T>.getResponse():T{
    return suspendCoroutine { continuation ->
        enqueue(object :Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body=response.body()
                if (body!=null){
                    //非空返回数据
                    continuation.resume(body)
                }else{
                    //数据为空报错
                    continuation.resumeWithException(RuntimeException("response body is null!"))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })
    }
}