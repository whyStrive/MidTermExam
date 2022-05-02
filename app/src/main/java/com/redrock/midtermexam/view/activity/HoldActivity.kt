package com.redrock.midtermexam.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.midtermexam.R
import com.example.midtermexam.databinding.ActivityHoldBinding
import com.redrock.midtermexam.util.gone
import com.redrock.midtermexam.util.visible
import com.redrock.midtermexam.view.fragment.ColorFragment
import com.redrock.midtermexam.view.fragment.IdeaFragment

class HoldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //使用viewBinding
        val binding = ActivityHoldBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //取出数据
        val choice = intent.getIntExtra("choice", -1)

        when (choice) {
            1-> {binding.ivHoldRightIcon.visible()
                binding.ivHoldRightIcon.setImageResource(R.mipmap.ic_hold_search)
                replaceFragment(ColorFragment)
            }
            2 -> {binding.tvHoldTitle.text = "灵感"
                binding.ivHoldRightIcon.gone()
                replaceFragment(IdeaFragment)
            }
        }


        //返回按钮
        binding.ivHoldBack.setOnClickListener { finish() }
    }

    //替换fragment
    private fun replaceFragment (frag:Fragment){
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.hold_frameLayout,frag)
        transaction.commit()
    }
}