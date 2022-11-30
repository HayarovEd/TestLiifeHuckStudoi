package com.edurda77.testliifehuckstudoi.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.testliifehuckstudoi.databinding.ItemRvBinding
import com.edurda77.testliifehuckstudoi.domain.entity.ItemCompany

class MainAdapter (private val onClickListener: OnStateClickListener) : RecyclerView.Adapter<MainHolder>(){

    private val differCallback = object : DiffUtil.ItemCallback<ItemCompany>() {
        override fun areItemsTheSame(oldItem: ItemCompany, newItem: ItemCompany): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemCompany, newItem: ItemCompany): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    interface OnStateClickListener {
        fun onStateClick(itemCompany: ItemCompany, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainHolder(ItemRvBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClickListener.onStateClick(item, position)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}