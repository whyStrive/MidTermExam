package com.redrock.midtermexam.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.midtermexam.R
import com.google.android.material.imageview.ShapeableImageView
import com.redrock.midtermexam.model.IdeaRv
import com.redrock.midtermexam.util.toast

/**
 * @author : why
 * @time : 2022/5/1 12:01
 * @email: why_wanghy@qq.com
 */
class IdeaRvAdapter(private val ideaList: ArrayList<IdeaRv>) :
    RecyclerView.Adapter<IdeaRvAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //懒加载获取view
        //左侧iv和tv
        val leftIv: ShapeableImageView by lazy {
            view.findViewById(R.id.iv_idea_leftImage)
        }
        val leftBorder: ShapeableImageView by lazy {
            view.findViewById(R.id.iv_idea_leftBorder)
        }
        val leftTv: TextView by lazy {
            view.findViewById(R.id.tv_idea_leftText)
        }

        //右侧
        val rightIv: ShapeableImageView by lazy {
            view.findViewById(R.id.iv_idea_rightImage)
        }
        val rightBorder: ShapeableImageView by lazy {
            view.findViewById(R.id.iv_idea_rightBorder)
        }
        val rightTv: TextView by lazy {
            view.findViewById(R.id.tv_idea_rightText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_idea_rv, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.rightIv.setOnClickListener {
            "详情".toast()
        }
        viewHolder.leftIv.setOnClickListener {
            "详情".toast()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //根据position判断图片在左边还是在右边，并加载图片
        val idea = ideaList[position]
        //position%2 为零，图片加载在左边
        if (position % 2 == 0) {
            Glide
                .with(holder.leftIv)
                .load(idea.imageUrl.replace("https", "http"))
                //未加载出来，使用app图标占位
                .placeholder(R.mipmap.ic_app)
                .into(holder.leftIv)
            //设置右边文字边框
            holder.rightBorder.setImageResource(R.mipmap.ic_idea_border)
            //设置右边文字
            holder.rightTv.text = idea.name
        }
        //position%2 不为零，图片加载在右边,以下操作同上
        else {
            Glide
                .with(holder.rightIv)
                .load(idea.imageUrl.replace("https", "http"))
                .placeholder(R.mipmap.ic_app)
                .into(holder.rightIv)
            holder.leftBorder.setImageResource(R.mipmap.ic_idea_border)
            holder.leftTv.text = idea.name
        }
    }

    override fun getItemCount(): Int = ideaList.size
}