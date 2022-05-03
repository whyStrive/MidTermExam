package com.redrock.midtermexam.network

import com.redrock.midtermexam.model.ColorModel
import com.redrock.midtermexam.model.ColorPageModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : why
 * @time : 2022/5/2 11:20
 * @email: why_wanghy@qq.com
 */
interface ColorService {
    //颜色page
    @GET("color/page")
    fun colorPage(): Call<ColorPageModel>

    //每一页颜色
    @GET("color/color_list")
    fun color(@Query("theme_id") themeId:Int): Call<ColorModel>
}