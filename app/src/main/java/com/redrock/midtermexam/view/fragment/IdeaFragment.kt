package com.redrock.midtermexam.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midtermexam.databinding.FragmentIdeaBinding
import com.redrock.midtermexam.config.APP
import com.redrock.midtermexam.model.IdeaRv
import com.redrock.midtermexam.view.adapter.IdeaRvAdapter
import com.redrock.midtermexam.view.viewmodel.IdeaViewModel
import kotlinx.coroutines.launch

/**
 * @author : why
 * @time : 2022/5/1 09:19
 * @email: why_wanghy@qq.com
 */
class IdeaFragment : Fragment() {


    //rv
    val ideaList = ArrayList<IdeaRv>()

    private var binding: FragmentIdeaBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIdeaBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //获取viewModel
        val vm = ViewModelProvider(this).get(IdeaViewModel::class.java)
        //初始化rv
        lifecycleScope.launch {
            binding?.let {
                initIdeaRv(vm, it)
            }
        }
    }

    //初始化rv
    private suspend fun initIdeaRv(vm: IdeaViewModel, binding: FragmentIdeaBinding) {
        for (it in 0 until vm.getIdeaResult().data.size) {
            val id = vm.getIdeaResult().data[it].id
            val name = vm.getIdeaResult().data[it].name
            val imageUrl = vm.getIdeaResult().data[it].imageUrl
            ideaList.add(IdeaRv(id, name, imageUrl))
        }
        binding.rvIdea.layoutManager = LinearLayoutManager(APP.appContext)
        binding.rvIdea.adapter = IdeaRvAdapter(ideaList)
    }
}