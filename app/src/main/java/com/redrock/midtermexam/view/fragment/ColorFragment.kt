package com.redrock.midtermexam.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.midtermexam.databinding.FragmentColorBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.redrock.midtermexam.view.adapter.ColorVpAdapter
import com.redrock.midtermexam.view.viewmodel.ColorViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

/**
 * @author : why
 * @time : 2022/5/2 11:31
 * @email: why_wanghy@qq.com
 */
object ColorFragment : Fragment() {


    lateinit var binding: FragmentColorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentColorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //获取ViewModel
        val vm = ViewModelProvider(requireActivity()).get(ColorViewModel::class.java)
        /*
        * viewPager2
        * */
        val fragments = ArrayList<VpColorFragment>()
        lifecycleScope.launch {
            //获取数量
            val len = vm.getColorPage().data.count
            //放入fragment
            repeat(len) {
                fragments.add(VpColorFragment())
            }
        }
        binding.vpColor.adapter = ColorVpAdapter(requireActivity(), fragments)
        //设置tabLayout
        TabLayoutMediator(
            binding.tabLayout,
            binding.vpColor,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    tab.setText("-")
                }
            }
        ).attach()

        //用LiveData获取当前fragment页码(用于更新activity顶上的title以及fragment的rv取page)
        val page=MutableLiveData<Int>()
        page.value=1
        /*thread {
            while (true){
                page.value= binding.vpColor.currentItem
            }
        }*/
        page.observe(requireActivity()){page->
            vm.page=page
        }
    }
}