package com.project.iosephknecht.barcode_view.presentation.bookmark

import android.databinding.Bindable
import com.project.iosephknecht.barcode_view.data.presentation.Bookmark
import com.project.iosephknecht.barcode_view.viper.interactor.MvpInteractor
import com.project.iosephknecht.barcode_view.viper.presenter.MvpPresenter
import com.project.iosephknecht.barcode_view.viper.router.MvpRouter
import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent
import com.project.iosephknecht.barcode_view.viper.viewModel.MvpViewModel

interface BookmarkContract {

    interface ViewModel : MvpViewModel {
        var bookmarkList: List<Bookmark>
            @Bindable get
    }

    interface Presenter : MvpPresenter<ViewModel> {
        fun obtainBookmarkList()
        fun jumpToInfoFragment(id: Long)
    }

    interface Listener : MvpInteractor.Listener {
        fun onObtainBookmarkList(bookmarkList: List<Bookmark>)
    }

    interface Interactor : MvpInteractor<Listener> {
        fun getBookmarkList()
    }

    interface RouterListener : MvpRouter.Listener

    interface Router : MvpRouter<RouterListener> {
        fun showInfoFragment(androidComponent: AndroidComponent, id: Long)
    }
}