package com.project.iosephknecht.barcode_view.presentation.bookmark.viewModel

import android.databinding.Bindable
import com.project.iosephknecht.barcode_view.data.presentation.Bookmark
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.viper.viewModel.AbstractViewModel
import com.project.iosephknecht.barcode_view.BR

class BookmarkViewModel : AbstractViewModel(), BookmarkContract.ViewModel {
    override var state = BookmarkContract.State.IDLE

    override var bookmarkList: List<Bookmark> = listOf()
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.bookmarkList)
        }
}