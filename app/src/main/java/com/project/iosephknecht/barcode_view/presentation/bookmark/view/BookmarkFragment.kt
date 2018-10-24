package com.project.iosephknecht.barcode_view.presentation.bookmark.view

import android.databinding.Observable
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.application.AppDelegate
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.presentation.bookmark.di.BookmarkComponent
import com.project.iosephknecht.barcode_view.presentation.bookmark.di.BookmarkModule
import com.project.iosephknecht.barcode_view.viper.view.AbstractFragment
import kotlinx.android.synthetic.main.fragment_bookmark.*
import com.project.iosephknecht.barcode_view.BR

class BookmarkFragment : AbstractFragment<BookmarkContract.ViewModel, BookmarkContract.Presenter>() {

    companion object {
        const val TAG = "bookmark_fragment"

        fun newInstance() = BookmarkFragment()
    }

    private lateinit var diComponent: BookmarkComponent
    private lateinit var adapter: BookmarkAdapter

    override fun injectDi() {
        diComponent = AppDelegate.presentationComponent
                .bookmarkSubmodule(BookmarkModule())
    }

    override fun createPresenter() = diComponent.getPresenter()

    override fun createViewModel() = diComponent.getViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = BookmarkAdapter { presenter!!.jumpToInfoFragment(it) }

        viewModel!!.addOnPropertyChangedCallback(vmObserver)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onStart() {
        super.onStart()

        bookmark_list.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(false)
            adapter = this@BookmarkFragment.adapter
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }

    override fun onDestroy() {
        viewModel!!.removeOnPropertyChangedCallback(vmObserver)
        super.onDestroy()
    }

    private val vmObserver by lazy {
        object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when (propertyId) {
                    BR.bookmarkList -> {
                        adapter.bookmarkList = viewModel!!.bookmarkList
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }
}