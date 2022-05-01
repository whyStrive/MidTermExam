package com.redrock.midtermexam

import com.redrock.midtermexam.model.LoginModel
import com.redrock.midtermexam.network.IdeaService
import com.redrock.midtermexam.network.ServiceCreator
import com.redrock.midtermexam.util.getResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author : why
 * @time : 2022/4/30 17:41
 * @email: why_wanghy@qq.com
 */
object Repository {

    private val api = ServiceCreator.create<IdeaService>()

    //登录
    suspend fun getLoginResult(phoneNum: Long): LoginModel =
        withContext(Dispatchers.IO) {
            api.login(phoneNum).getResponse()
        }

    //注册
    suspend fun getRegisterResult(phoneNum: Long, name: String) =
        withContext(Dispatchers.IO) {
            api.register(phoneNum, name).getResponse()
        }

    //灵感首页
    suspend fun getIdeaResult()=
        withContext(Dispatchers.IO){
            api.idea().getResponse()
        }
}