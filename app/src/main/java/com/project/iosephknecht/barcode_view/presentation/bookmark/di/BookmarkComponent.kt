package com.project.iosephknecht.barcode_view.presentation.bookmark.di

import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract

interface BookmarkComponent {
    fun getPresenter(): BookmarkContract.Presenter
    fun getViewModel(): BookmarkContract.ViewModel
}