package com.project.iosephknecht.barcode_view.presentation.bookmark.view

import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.viper.view.AbstractFragment

class BookmarkFragment : AbstractFragment<BookmarkContract.ViewModel, BookmarkContract.Presenter>() {

    companion object {
        const val TAG = "bookmark_fragment"

        fun newInstance() = BookmarkFragment()
    }

    private lateinit var diComponent: BookmarkContract
    //private lateinit var bindingComponent:

    override fun injectDi() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createPresenter(): BookmarkContract.Presenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createViewModel(): BookmarkContract.ViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}