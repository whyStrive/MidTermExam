package com.redrock.midtermexam.network

import com.redrock.midtermexam.model.IdeaModel
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author : why
 * @time : 2022/4/30 17:36
 * @email: why_wanghy@qq.com
 */

interface IdeaService {

    //灵感首页
    @GET("idea/idea")
    fun idea(): Call<IdeaModel>

}