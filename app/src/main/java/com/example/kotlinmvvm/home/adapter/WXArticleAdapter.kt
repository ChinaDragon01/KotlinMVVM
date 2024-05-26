package com.example.kotlinmvvm.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.baselib.bean.WXArticleBean
import com.example.kotlinmvvm.R

/**
 *Author: chinadragon
 *Time: 2024/5/26
 */
class WXArticleAdapter(
    val mDatas: MutableList<WXArticleBean> = mutableListOf()
) : RecyclerView.Adapter<WXArticleAdapter.WXArticleViewHodler>() {

    inner class WXArticleViewHodler(itemView: View) : ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)!!
        val tvOrder = itemView.findViewById<TextView>(R.id.tvOrder)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WXArticleViewHodler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wxarticle, parent, false)
        return WXArticleViewHodler(view)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: WXArticleViewHodler, position: Int) {
        val wxArticleBean = mDatas[position]
        with(wxArticleBean) {
            holder.tvOrder.text = "${order ?: ""}"
            holder.tvName.text = name
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(datas: List<WXArticleBean>?) {
        if (datas.isNullOrEmpty()) {
            return
        }
        mDatas.clear()
        mDatas.addAll(datas)
        notifyDataSetChanged()
    }

}