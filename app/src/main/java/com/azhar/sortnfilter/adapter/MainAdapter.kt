package com.azhar.sortnfilter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azhar.sortnfilter.R
import com.azhar.sortnfilter.model.ModelMain
import kotlinx.android.synthetic.main.list_item_main.view.*

/**
 * Created by Azhar Rivaldi on 04-02-2022
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class MainAdapter(var modelPenugasanList: List<ModelMain>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelPenugasanList[position]

        holder.tvRadius.text = data.strRadius
        holder.tvNama.text = data.strNama
        holder.tvDetail.text = data.strDetail
    }

    override fun getItemCount(): Int {
        return modelPenugasanList.size
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvRadius: TextView = itemView.tvRadius
        var tvNama: TextView = itemView.tvNama
        var tvDetail: TextView = itemView.tvDetail
    }

}