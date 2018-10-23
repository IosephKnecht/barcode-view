package com.project.iosephknecht.barcode_view.presentation.bookmark.presenter

import com.project.iosephknecht.barcode_view.data.presentation.Bookmark
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.viper.presenter.AbstractPresenter
import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent

class BookmarkPresenter(private val interactor: BookmarkContract.Interactor,
                        private val router: BookmarkContract.Router) : AbstractPresenter<BookmarkContract.ViewModel>(),
    BookmarkContract.Presenter, BookmarkContract.Listener {

    override fun attachView(viewModel: BookmarkContract.ViewModel, androidComponent: AndroidComponent) {
        super.attachView(viewModel, androidComponent)
        interactor.setListener(this)

        when (viewModel.state) {
            BookmarkContract.State.IDLE -> obtainBookmarkList()
            else -> {
            }
        }
    }

    override fun detachView() {
        androidComponent = null
        super.detachView()
    }

    override fun obtainBookmarkList() {
        interactor.getBookmarkList()
    }

    override fun jumpToInfoFragment(id: Long) {
        //router.showInfoFragment(id)
    }

    override fun onObtainBookmarkList(bookmarkList: List<Bookmark>) {
        viewModel!!.bookmarkList = bookmarkList
        viewModel!!.state = BookmarkContract.State.INIT
    }
}