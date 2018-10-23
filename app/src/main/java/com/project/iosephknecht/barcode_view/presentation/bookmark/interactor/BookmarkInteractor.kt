package com.project.iosephknecht.barcode_view.presentation.bookmark.interactor

import com.project.iosephknecht.barcode_view.domain.services.SharedPrefService
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.viper.interactor.AbstractInteractor
import io.reactivex.Observable

class BookmarkInteractor(private val sharedPrefService: SharedPrefService)
    : AbstractInteractor<BookmarkContract.Listener>(), BookmarkContract.Interactor {

    override fun getBookmarkList() {
        discardResult(Observable.fromCallable { sharedPrefService.getBookmarkList() }) { listener, result ->
            result.data { listener!!.onObtainBookmarkList(this) }
        }
    }
}