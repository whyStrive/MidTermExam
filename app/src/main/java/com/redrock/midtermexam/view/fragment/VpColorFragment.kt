package com.redrock.midtermexam.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.midtermexam.databinding.FragmentVpColorBinding
import com.redrock.midtermexam.config.APP
import com.redrock.midtermexam.model.ColorRv
import com.redrock.midtermexam.view.adapter.ColorRvAdapter
import com.redrock.midtermexam.view.viewmodel.ColorViewModel
import kotlinx.coroutines.launch

/**
 * @author : why
 * @time : 2022/5/2 15:18
 * @email: why_wanghy@qq.com
 */
class VpColorFragment(val current: Int) : Fragment() {

    //ViewBinding
    private var binding: FragmentVpColorBinding? = null

    //颜色rv
    val colorList = ArrayList<ColorRv>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVpColorBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //获取ViewModel（虽然是外一层fragment的ViewModel，不过应该没啥影响吧？）
        val vm = ViewModelProvider(this).get(ColorViewModel::class.java)
        binding?.rvColorVp?.let {
            initColorRv(vm, current)
        }
    }

    //初始化rv
    private fun initColorRv(vm: ColorViewModel, current: Int) {
        //先清除
        lifecycleScope.launch {
            //添加颜色
            repeat(vm.getColor(current).data.colorList.size) {
                val id = vm.getColor(current).data.colorList[it].id
                val name = vm.getColor(current).data.colorList[it].name
                val hex = vm.getColor(current).data.colorList[it].hex
                val r = vm.getColor(current).data.colorList[it].r
                val g = vm.getColor(current).data.colorList[it].g
                val b = vm.getColor(current).data.colorList[it].b
                val c = vm.getColor(current).data.colorList[it].c
                val m = vm.getColor(current).data.colorList[it].m
                val k = vm.getColor(current).data.colorList[it].k
                val y = vm.getColor(current).data.colorList[it].y
                colorList.add(ColorRv(id, name, hex, r, g, b, c, m, k, y))
            }
        }
        binding?.rvColorVp?.layoutManager = LinearLayoutManager(APP.appContext)
        binding?.rvColorVp?.adapter = ColorRvAdapter(colorList)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}