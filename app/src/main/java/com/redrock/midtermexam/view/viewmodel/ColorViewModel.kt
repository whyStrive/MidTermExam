package com.redrock.midtermexam.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.redrock.midtermexam.Repository
import com.redrock.midtermexam.model.ColorModel
import com.redrock.midtermexam.model.ColorPageModel

/**
 * @author : why
 * @time : 2022/5/2 16:06
 * @email: why_wanghy@qq.com
 */
class ColorViewModel : ViewModel() {

    //var page:Int=1
    val page = MutableLiveData<Int>()


    //颜色page
    suspend fun getColorPage(): ColorPageModel =
        Repository.getColorPage()


    //颜色
    suspend fun getColor(themeId: Int): ColorModel =
        Repository.getColor(themeId)
}