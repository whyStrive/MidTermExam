package com.redrock.midtermexam.view.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.midtermexam.databinding.ActivityLoginBinding
import com.redrock.midtermexam.MainActivity
import com.redrock.midtermexam.model.LoginModel
import com.redrock.midtermexam.util.start
import com.redrock.midtermexam.util.startWithData
import com.redrock.midtermexam.util.toast
import com.redrock.midtermexam.view.viewmodel.LoginViewModel
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        //获取viewModel
        val vm = ViewModelProvider(this).get(LoginViewModel::class.java)

        //清空电话号码按钮
        binding.itnDeletePhoneNum.setOnClickListener {
            binding.etLoginPhoneNum.setText("")
        }

        //清空用户名按钮
        binding.itnDeleteName.setOnClickListener {
            binding.etLoginName.setText("")
        }

        //登录
        binding.btnLogin.setOnClickListener {
            //取得手机号
            val phoneNum = binding.etLoginPhoneNum.text.toString()
            //用户名
            val name = binding.etLoginName.text.toString()
            //判断手机号和用户名是否合法
            if (phoneNum.length != 11) {
                "请在上方输入正确的手机号！".toast()
            } else if (name == "") {
                "请在上方输入用户名！".toast()
            } else if (phoneNum.length != 11 && name == "") {
                "请在上方输入正确的手机号和用户名！".toast()
            } else {
                //记住账户
                val editor = getSharedPreferences("account", Context.MODE_PRIVATE).edit()
                if (!binding.cbLogin.isChecked) {
                    editor.clear()
                } else {
                    editor.apply {
                        putLong("phoneNum", binding.etLoginPhoneNum.text.toString().toLong())
                        putString("name", binding.etLoginName.text.toString())
                        putBoolean("remember", true)
                        apply()
                    }
                }
                //网络请求
                lifecycleScope.launch {
                    //请求结果
                    val result = vm.getLoginResult(phoneNum.toLong())
                    if (result.message == "OK") {
                        start<MainActivity>()
                    } else if (result.message == "账号不存在") {
                        "账号不存在！请检查账号后重新登录或注册新账号".toast()
                    }
                    //保存token
                    editor.apply {
                        putString("token",result.data.token)
                        putString("refreshToken",result.data.refreshToken)
                    }
                }
            }
        }
        //注册
        binding.tvLoginRegister.setOnClickListener {
            //手机号
            val phoneNum = binding.etLoginPhoneNum.text.toString()
            //用户名
            val name = binding.etLoginName.text.toString()
            if (phoneNum.length != 11) {
                "请在上方输入正确的手机号！".toast()
            } else if (name == "") {
                "请在上方输入用户名！".toast()
            } else if (phoneNum.length != 11 && name == "") {
                "请在上方输入正确的手机号和用户名！".toast()
            } else {
                //结果
                lifecycleScope.launch {
                    val result = vm.getRegisterResult(phoneNum.toLong(), name)
                    if (result.message == "成功注册") {
                        "注册成功！现在您可以用此账号登录".toast()
                    } else if (result.message == "账号已存在") {
                        "该账号已存在！".toast()
                    }
                }
            }
        }

        //检查是否保存账户，是则自动输入内容
        val prefs = getSharedPreferences("account", Context.MODE_PRIVATE)
        if (prefs.getBoolean("remember", false)) {
            val phoneNum = prefs.getLong("phoneNum", 0L)
            val name = prefs.getString("name", "保存账户失败")
            binding.etLoginPhoneNum.setText(phoneNum.toString())
            binding.etLoginName.setText(name)
            binding.cbLogin.isChecked = true
        } else {
            binding.cbLogin.isChecked = false
        }
    }
}
