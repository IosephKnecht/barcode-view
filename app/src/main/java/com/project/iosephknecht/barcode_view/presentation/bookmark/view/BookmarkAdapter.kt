package com.project.iosephknecht.barcode_view.presentation.bookmark.view

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.data.presentation.Bookmark
import com.project.iosephknecht.barcode_view.databinding.ItemBookmarkBinding

class BookmarkAdapter(private val clickListener: ((Long) -> Unit))
    : RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {
    var bookmarkList = listOf<Bookmark>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemBookmarkBinding>(LayoutInflater.from(parent.context),
                R.layout.item_bookmark, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = bookmarkList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.bookmark = bookmarkList[position]
        holder.binding.root.setOnClickListener { clickListener.invoke(bookmarkList[position].id) }
    }

    class ViewHolder(val binding: ItemBookmarkBinding) : RecyclerView.ViewHolder(binding.root)
}