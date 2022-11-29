package com.edurda77.testliifehuckstudoi.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edurda77.testliifehuckstudoi.R
import com.edurda77.testliifehuckstudoi.databinding.ItemRvBinding
import com.edurda77.testliifehuckstudoi.domain.BASE_URL
import com.edurda77.testliifehuckstudoi.domain.entity.ItemCompany

class MainHolder(private val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemCompany: ItemCompany) {
        binding.nameTv.text = itemCompany.name
        val urlPoster = BASE_URL + itemCompany.img
        Glide.with(this.itemView.context)
            .load(urlPoster)
            .placeholder(R.drawable.ic_no_image)
            .into(binding.imgIv)
    }
}