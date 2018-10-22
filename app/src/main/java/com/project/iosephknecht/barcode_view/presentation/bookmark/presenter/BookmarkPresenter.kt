package com.project.iosephknecht.barcode_view.presentation.bookmark.presenter

import com.project.iosephknecht.barcode_view.data.presentation.Bookmark
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.viper.presenter.AbstractPresenter
import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent

class BookmarkPresenter(private val interactor: BookmarkContract.Interactor) : AbstractPresenter<BookmarkContract.ViewModel>(),
    BookmarkContract.Presenter, BookmarkContract.Listener {

    override fun attachView(viewModel: BookmarkContract.ViewModel, androidComponent: AndroidComponent) {
        super.attachView(viewModel, androidComponent)
    }

    override fun obtainBookmarkList() {
        interactor.getBookmarkList()
    }

    override fun onObtainBookmarkList(bookmarkList: List<Bookmark>) {

    }
}