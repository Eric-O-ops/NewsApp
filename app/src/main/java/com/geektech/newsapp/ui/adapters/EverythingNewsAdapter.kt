package com.geektech.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.newsapp.databinding.ItemNewsBinding
import com.geektech.newsapp.model.EverythingNewsModel

class EverythingNewsAdapter :
    PagingDataAdapter<EverythingNewsModel, EverythingNewsAdapter.ViewHolder>(diffUtil) {

    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: EverythingNewsModel?) = with(binding) {
            itemTitle.text = item?.title
            itemAuthor.text = item?.author
            Glide.with(itemImage).load(item?.urlToImage).into(itemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<EverythingNewsModel>() {
            override fun areItemsTheSame(
                oldItem: EverythingNewsModel,
                newItem: EverythingNewsModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: EverythingNewsModel,
                newItem: EverythingNewsModel
            ): Boolean {
                return oldItem.urlToImage == newItem.urlToImage
            }
        }
    }
}