package com.redrock.midtermexam.model

import com.google.gson.annotations.SerializedName

/**
 * @author : why
 * @time : 2022/5/2 11:08
 * @email: why_wanghy@qq.com
 */
data class ColorPageModel(
    val code:Int,
    val message:String,
    val data:ColorPageData
)

data class ColorPageData(
    val count:Int,
    @SerializedName("list")
    val colorList:List<ColorPage>
)

data class ColorPage(
    val id:Int,
    val theme:String
)
