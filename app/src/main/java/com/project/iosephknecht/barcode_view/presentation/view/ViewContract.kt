package com.project.iosephknecht.barcode_view.presentation.view

import android.databinding.Bindable
import com.project.iosephknecht.barcode_view.viper.interactor.MvpInteractor
import com.project.iosephknecht.barcode_view.viper.presenter.MvpPresenter
import com.project.iosephknecht.barcode_view.viper.viewModel.MvpViewModel

interface ViewContract {

    interface ViewModel : MvpViewModel {
        var modelArray: ByteArray
            @Bindable get
    }

    interface Presenter : MvpPresenter<ViewModel> {
        fun obtainModel(id: Long)
    }

    interface Listener : MvpInteractor.Listener {
        fun onObtainModel(modelArray: ByteArray)
    }

    interface Interactor : MvpInteractor<Listener> {
        fun getModel(id: Long)
    }
}