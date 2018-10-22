package com.project.iosephknecht.barcode_view.presentation.bookmark.view

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.project.iosephknecht.barcode_view.data.presentation.Bookmark
import com.project.iosephknecht.barcode_view.databinding.ItemBookmarkBinding

class BookmarkAdapter(private val clickListener: (() -> Unit))
    : RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {
    var bookmarkList = listOf<Bookmark>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.bind(parent)!!)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemView: ItemBookmarkBinding) : RecyclerView.ViewHolder(itemView.root) {

    }
}