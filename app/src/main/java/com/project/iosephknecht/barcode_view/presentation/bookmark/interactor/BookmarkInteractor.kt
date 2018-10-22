package com.project.iosephknecht.barcode_view.presentation.bookmark.interactor

import com.project.iosephknecht.barcode_view.domain.SharedPrefService
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.viper.interactor.AbstractInteractor

class BookmarkInteractor(private val sharedPrefService: SharedPrefService)
    : AbstractInteractor<BookmarkContract.Listener>(), BookmarkContract.Interactor {

    override fun getBookmarkList() {

    }
}