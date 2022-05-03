package com.redrock.midtermexam.model

import com.google.gson.annotations.SerializedName

/**
 * @author : why
 * @time : 2022/5/1 11:47
 * @email: why_wanghy@qq.com
 */
data class IdeaModel(
    val code: Int,
    val message: String,
    val data: List<IdeaBean>
)

data class IdeaBean(
    val id: Int,
    val name: String,
    @SerializedName("image")
    val imageUrl: String
)
