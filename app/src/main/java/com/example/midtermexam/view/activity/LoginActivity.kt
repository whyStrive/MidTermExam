package com.example.midtermexam.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.midtermexam.MainActivity
import com.example.midtermexam.databinding.ActivityLoginBinding
import com.example.midtermexam.util.startWithData
import com.example.midtermexam.util.toast
import com.example.midtermexam.view.viewmodel.LoginViewModel
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
            //请求结果
            if (phoneNum.length != 11) {
                "请在上方输入正确的手机号！".toast()
            } else if (name == "") {
                "请在上方输入用户名！".toast()
            } else if (phoneNum.length != 11 && name == "") {
                "请在上方输入正确的手机号和用户名！".toast()
            } else {
                lifecycleScope.launch {
                    val result = vm.getLoginResult(phoneNum.toLong())
                    if (result.message == "OK") {
                        startWithData<MainActivity> {
                            putExtra("token", result.data.token)
                            putExtra("refreshToken", result.data.refreshToken)
                        }
                    } else if (result.message == "账号不存在") {
                        "账号不存在！请检查账号后重新登录或注册新账号".toast()
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
                    } else if (result.message == "账号已存在！") {
                        "该账号已存在！".toast()
                    }
                }
            }
        }
    }
}
