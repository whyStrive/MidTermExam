package com.redrock.midtermexam

import com.redrock.midtermexam.model.LoginModel
import com.redrock.midtermexam.network.ColorService
import com.redrock.midtermexam.network.IdeaService
import com.redrock.midtermexam.network.LoginService
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
    //灵感
    private val ideaService = ServiceCreator.create<IdeaService>()

    //登录
    private val loginService = ServiceCreator.create<LoginService>()

    //颜色
    private val colorService = ServiceCreator.create<ColorService>()


    //登录
    suspend fun getLoginResult(phoneNum: Long): LoginModel =
        withContext(Dispatchers.IO) {
            loginService.login(phoneNum).getResponse()
        }

    //注册
    suspend fun getRegisterResult(phoneNum: Long, name: String) =
        withContext(Dispatchers.IO) {
            loginService.register(phoneNum, name).getResponse()
        }

    //灵感首页
    suspend fun getIdeaResult() =
        withContext(Dispatchers.IO) {
            ideaService.idea().getResponse()
        }

    //颜色page
    suspend fun getColorPage() =
        withContext(Dispatchers.IO) {
            colorService.colorPage().getResponse()
        }

    //颜色
    suspend fun getColor(themeId: Int) =
        withContext(Dispatchers.IO) {
            colorService.color(themeId).getResponse()
        }
}