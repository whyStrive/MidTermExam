package com.redrock.midtermexam.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.redrock.midtermexam.view.fragment.VpColorFragment

/**
 * @author : why
 * @time : 2022/5/2 16:20
 * @email: why_wanghy@qq.com
 *
 * 颜色首页vp2 的adapter ，vp2与fragment联合
 *
 */
class ColorVpAdapter(activity:FragmentActivity,private val fragments:ArrayList<VpColorFragment>) :FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}