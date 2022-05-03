package com.redrock.midtermexam.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.midtermexam.R
import com.example.midtermexam.databinding.ActivityHoldBinding
import com.redrock.midtermexam.config.APP
import com.redrock.midtermexam.util.gone
import com.redrock.midtermexam.util.visible
import com.redrock.midtermexam.view.fragment.ColorFragment
import com.redrock.midtermexam.view.fragment.IdeaFragment
import com.redrock.midtermexam.view.fragment.SearchFragment
import com.redrock.midtermexam.view.viewmodel.ColorViewModel
import kotlinx.coroutines.launch

class HoldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //使用viewBinding
        val binding = ActivityHoldBinding.inflate(layoutInflater)
        //沉浸式状态栏
        val choice = intent.getIntExtra("choice", -1)
        if (choice==1){
            setTheme(R.style.ColorFragmentTheme)
        }else{
            setTheme(R.style.LoginActivityTheme)
        }
        setContentView(binding.root)
        supportActionBar?.hide()

        //判断fragment并进行相关操作
        when (choice) {
            //色谱
            1-> {binding.ivHoldRightIcon.visible()
                binding.ivHoldRightIcon.apply {
                    setImageResource(R.mipmap.ic_hold_search)
                    setOnClickListener {
                        replaceFragment(SearchFragment(),true)
                        this.gone()
                    }
                }
                //获取颜色并加载到title上
                lifecycleScope.launch {
                    val vm = ViewModelProvider(this@HoldActivity).get(ColorViewModel::class.java)
                    vm.page.observe(this@HoldActivity){
                        lifecycleScope.launch {
                            binding.tvHoldTitle.text=vm.getColorPage().data.colorList[vm.page.value!!].theme
                        }
                    }
                    binding.constraintLayout.setBackgroundColor(APP.appContext.resources.getColor(R.color.hold_back))
                    replaceFragment(ColorFragment(),false)
                }


            }
            //灵感
            2 -> {binding.tvHoldTitle.text = "灵感"
                binding.ivHoldRightIcon.gone()
                replaceFragment(IdeaFragment(),false)
            }
        }


        //返回按钮
        binding.ivHoldBack.setOnClickListener { finish() }
    }

    //替换fragment
    private fun replaceFragment (frag:Fragment,add:Boolean){
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.hold_frameLayout,frag)
        if (add) {
            //加入返回栈
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}