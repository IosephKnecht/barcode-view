package com.project.iosephknecht.barcode_view.presentation.bookmark.view

import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.presentation.bookmark.di.BookmarkComponent
import com.project.iosephknecht.barcode_view.viper.view.AbstractFragment

class BookmarkFragment : AbstractFragment<BookmarkContract.ViewModel, BookmarkContract.Presenter>() {

    companion object {
        const val TAG = "bookmark_fragment"

        fun newInstance() = BookmarkFragment()
    }

    private lateinit var diComponent: BookmarkComponent
    //private lateinit var bindingComponent:

    override fun injectDi() {
        // TODO: init BookmarkComponent
    }

    override fun createPresenter() = diComponent.getPresenter()

    override fun createViewModel() = diComponent.getViewModel()

}