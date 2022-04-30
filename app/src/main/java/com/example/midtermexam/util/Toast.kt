package com.example.midtermexam.util

import android.widget.Toast
import com.example.midtermexam.config.APP

/**
 * @author : why
 * @time : 2022/4/30 09:59
 * @email: why_wanghy@qq.com
 */

//短时间显示
fun String.toast() {
    Toast.makeText(APP.appContext, this, Toast.LENGTH_SHORT).show()
}

//长时间
fun String.toastLong() {
    Toast.makeText(APP.appContext, this, Toast.LENGTH_LONG).show()
}