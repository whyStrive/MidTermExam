package com.redrock.midtermexam.model

import com.google.gson.annotations.SerializedName

/**
 * @author : why
 * @time : 2022/5/2 11:11
 * @email: why_wanghy@qq.com
 */
data class ColorModel(
    val code: Int,
    val message: String,
    val data: ColorData
)

data class ColorData(
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("color_list")
    val colorList: List<Color>
)

data class Color(
    val id: Int,
    val name: String,
    val hex: String,
    val r: Int,
    val g: Int,
    val b: Int,
    val c: Int,
    val m: Int,
    val k: Int,
    val y: Int
)
