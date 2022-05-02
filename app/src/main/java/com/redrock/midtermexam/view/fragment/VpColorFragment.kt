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
import com.example.midtermexam.databinding.FragmentIdeaBinding
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
class VpColorFragment : Fragment() {

    //ViewBinding
    lateinit var binding: FragmentVpColorBinding

    //颜色rv
    val colorList = ArrayList<ColorRv>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVpColorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //获取ViewModel（虽然是外一层fragment的ViewModel，不过应该没啥影响吧？）
        val vm = ViewModelProvider(this).get(ColorViewModel::class.java)
        initColorRv(vm,binding.rvColorVp)
    }

    //初始化rv
    private fun initColorRv(vm: ColorViewModel, rv: RecyclerView) {
        //先清除
        colorList.clear()
        lifecycleScope.launch {
            //添加颜色
            repeat(vm.getColor(vm.page).data.colorList.size) {
                colorList.add(
                    ColorRv(
                        vm.getColor(vm.page).data.colorList[it].id,
                        vm.getColor(vm.page).data.colorList[it].name,
                        vm.getColor(vm.page).data.colorList[it].hex,
                        vm.getColor(vm.page).data.colorList[it].r,
                        vm.getColor(vm.page).data.colorList[it].g,
                        vm.getColor(vm.page).data.colorList[it].b,
                        vm.getColor(vm.page).data.colorList[it].c,
                        vm.getColor(vm.page).data.colorList[it].m,
                        vm.getColor(vm.page).data.colorList[it].k,
                        vm.getColor(vm.page).data.colorList[it].y
                    )
                )
            }
            rv.layoutManager=LinearLayoutManager(APP.appContext)
            rv.adapter=ColorRvAdapter(colorList)
        }
    }
}