package com.redrock.midtermexam.view.viewmodel

import androidx.lifecycle.ViewModel
import com.redrock.midtermexam.Repository
import com.redrock.midtermexam.model.IdeaModel

/**
 * @author : why
 * @time : 2022/5/1 11:52
 * @email: why_wanghy@qq.com
 */
class IdeaViewModel : ViewModel() {

    //灵感首页
    suspend fun getIdeaResult(): IdeaModel =
        Repository.getIdeaResult()
}