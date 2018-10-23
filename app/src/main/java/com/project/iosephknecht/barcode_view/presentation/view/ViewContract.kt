package com.project.iosephknecht.barcode_view.presentation.view

import android.databinding.Bindable
import com.project.iosephknecht.barcode_view.viper.interactor.MvpInteractor
import com.project.iosephknecht.barcode_view.viper.presenter.MvpPresenter
import com.project.iosephknecht.barcode_view.viper.viewModel.MvpViewModel

interface ViewContract {

    enum class State {
        IDLE, INIT
    }

    interface ViewModel : MvpViewModel {
        var modelArray: ByteArray
            @Bindable get

        var state: State

        fun redrawModel()
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