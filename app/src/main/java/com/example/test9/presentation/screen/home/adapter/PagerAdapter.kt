package com.example.test9.presentation.screen.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test9.databinding.ItemPagerBinding
import com.example.test9.presentation.model.TouristicPlaceUI


class PagerAdapter: ListAdapter<TouristicPlaceUI, PagerAdapter.HomeImageViewHolder>(DiffCallback()) {

    inner class HomeImageViewHolder(private val binding: ItemPagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val touristicPlaceUI = currentList[position]
            binding.apply {
                tvPrise.text = touristicPlaceUI.price
                tvTitle.text = touristicPlaceUI.title
                Glide.with(itemView.context)
                    .load(touristicPlaceUI.cover)
                    .into(coverImage)
            }

        }
    }

    class DiffCallback : DiffUtil.ItemCallback<TouristicPlaceUI>() {
        override fun areItemsTheSame(oldItem: TouristicPlaceUI, newItem: TouristicPlaceUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TouristicPlaceUI, newItem: TouristicPlaceUI): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeImageViewHolder {
        val binding = ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeImageViewHolder, position: Int) {
        holder.bind(position)
    }
}