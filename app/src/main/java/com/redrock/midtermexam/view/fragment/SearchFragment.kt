package com.redrock.midtermexam.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.midtermexam.databinding.FragmentSearchBinding
import com.redrock.midtermexam.util.toast

/**
 * @author : why
 * @time : 2022/5/2 19:50
 * @email: why_wanghy@qq.com
 */
class SearchFragment : Fragment() {

    var binding: FragmentSearchBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.ivSearch?.setOnClickListener {
            binding?.etSearch?.text.toString().toast()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}