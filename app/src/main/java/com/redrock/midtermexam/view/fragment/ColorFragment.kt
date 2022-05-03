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
import androidx.viewpager2.widget.ViewPager2
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
class ColorFragment : Fragment() {


    private var binding: FragmentColorBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentColorBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //获取ViewModel
        val vm = ViewModelProvider(requireActivity()).get(ColorViewModel::class.java)
        /*
        * viewPager2
        * */
        val fragments = ArrayList<VpColorFragment>()
        viewLifecycleOwner.lifecycleScope.launch {
            //获取数量
            val len = vm.getColorPage().data.count
            //放入fragment
            repeat(len) {
                fragments.add(VpColorFragment(it + 1))
            }
            binding?.vpColor?.adapter = ColorVpAdapter(requireActivity(), fragments)
            //设置tabLayout
            binding?.let {
                TabLayoutMediator(
                    it.tabLayout,
                    it.vpColor,
                    object : TabLayoutMediator.TabConfigurationStrategy {
                        override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                            tab.setText("·")
                        }
                    }
                ).attach()
            }

            //设置监听，当前页面改变时，更新title和数据
            binding?.vpColor?.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    vm.page.value = binding?.vpColor?.currentItem!!
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}