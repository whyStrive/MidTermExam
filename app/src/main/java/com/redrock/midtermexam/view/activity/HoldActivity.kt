package com.redrock.midtermexam.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midtermexam.databinding.ActivityHoldBinding

class HoldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //使用viewBinding
        val binding = ActivityHoldBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //取出数据
        val token = intent.getStringExtra("token")
        val refreshToken = intent.getStringExtra("refreshToken")
        val choice = intent.getIntExtra("choice", -1)

        when (choice) {
            2 -> binding.tvHoldTitle.text = "灵感"
        }


        //返回按钮
        binding.ivHoldBack.setOnClickListener { finish() }
    }
}