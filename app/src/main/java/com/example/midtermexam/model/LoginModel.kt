package com.example.midtermexam.model

/**
 * @author : why
 * @time : 2022/4/30 21:33
 * @email: why_wanghy@qq.com
 */
data class LoginModel(
    val code: Int,
    val message: String,
    val data: Token
)

data class Token(
    val token: String,
    val refreshToken: String
)
