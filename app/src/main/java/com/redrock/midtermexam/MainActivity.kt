package com.redrock.midtermexam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.midtermexam.databinding.ActivityMainBinding
import com.redrock.midtermexam.util.startWithData
import com.redrock.midtermexam.view.activity.HoldActivity

class MainActivity : AppCompatActivity() {

    companion object{
        //以下为跳转时传参，用于HoldActivity判断具体该用那个fragment
        const val IDEA=2
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        


        //灵感
        binding.ivIdea.setOnClickListener{
            startHoldActivity(IDEA)
            finish()
        }
    }

    //启动HoldActivity的函数
    private fun startHoldActivity(choice:Int){
        //取出token
        val token=intent.getStringExtra("token")
        val refreshToken=intent.getStringExtra("refreshToken")
        //启动HoldActivity
        startWithData<HoldActivity> {
            putExtra("token",token)
            putExtra("refreshToken",refreshToken)
            putExtra("choice", choice)
        }
    }
}