package com.project.iosephknecht.barcode_view.presentation.bookmark.viewModel

import android.databinding.Bindable
import com.project.iosephknecht.barcode_view.data.presentation.Bookmark
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.viper.viewModel.AbstractViewModel

class BookmarkViewModel : AbstractViewModel(), BookmarkContract.ViewModel {
    override var bookmarkList: List<Bookmark> = listOf()
        @Bindable get
        set(value) {
            field = value
            notifyChange()
        }
}