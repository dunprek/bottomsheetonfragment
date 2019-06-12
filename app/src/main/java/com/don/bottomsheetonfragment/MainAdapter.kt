package com.don.bottomsheetonfragment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by gideon on 12,June,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */

class MainAdapter(val context: Context,
                          private val data: List<MdlExample>,
                          val onClickItem: OnClickItem) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var ivEx: ImageView
        var tvEx: TextView
        var llEx: LinearLayout

        init {
            itemView.setTag(adapterPosition)
            ivEx = itemView.findViewById(R.id.iv_example)
            tvEx = itemView.findViewById(R.id.tv_example)
            llEx = itemView.findViewById(R.id.ll_example)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): MainAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_example, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val result: MdlExample = data.get(position)

        holder.ivEx.setImageResource(result.image)

        holder.tvEx.text = result.name

        holder.llEx.setOnClickListener {
            onClickItem.onClickCard(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnClickItem {
        fun onClickCard(position: Int)
    }

}