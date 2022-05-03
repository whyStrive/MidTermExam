package com.redrock.midtermexam.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.midtermexam.R
import com.redrock.midtermexam.model.ColorRv
import com.redrock.midtermexam.util.toast

/**
 * @author : why
 * @time : 2022/5/2 15:37
 * @email: why_wanghy@qq.com
 *
 * 颜色首页的rv adapter
 *
 */
class ColorRvAdapter(private val colorList: ArrayList<ColorRv>) :
    RecyclerView.Adapter<ColorRvAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //获取view
        val name: TextView = view.findViewById(R.id.tv_color_name)
        val hex: TextView = view.findViewById(R.id.tv_color_hex)
        val rgb: TextView = view.findViewById(R.id.tv_color_rgb)
        val cmyk: TextView = view.findViewById(R.id.tv_color_cmyk)
        val constraintLayout: ConstraintLayout = view.findViewById(R.id.constraintLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_color_rv, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.apply {
            name.setOnClickListener { name.text.toString().toast() }
            hex.setOnClickListener { hex.text.toString().toast() }
            rgb.setOnClickListener { rgb.text.toString().toast() }
            cmyk.setOnClickListener { cmyk.text.toString().toast() }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val color = colorList[position]
        //Log.d("www", "(:)-->> $color");
        holder.constraintLayout.setBackgroundColor(android.graphics.Color.parseColor("#" + color.hex))
        holder.apply {
            name.text = color.name
            hex.text = color.hex
            rgb.text = "${color.r},${color.g},${color.b}"
            cmyk.text = "${color.c},${color.m},${color.y},${color.k}"
        }
    }

    override fun getItemCount(): Int = colorList.size
}