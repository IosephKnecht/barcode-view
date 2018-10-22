package com.project.iosephknecht.barcode_view.presentation.info

import android.databinding.Bindable
import com.project.iosephknecht.barcode_view.data.presentation.DocumentInfo
import com.project.iosephknecht.barcode_view.viper.interactor.MvpInteractor
import com.project.iosephknecht.barcode_view.viper.presenter.MvpPresenter
import com.project.iosephknecht.barcode_view.viper.router.MvpRouter
import com.project.iosephknecht.barcode_view.viper.viewModel.MvpViewModel

interface DocumentInfoContract {

    interface ViewModel : MvpViewModel {
        var description: String
            @Bindable get

        var modelArray: ByteArray
    }

    interface Presenter : MvpPresenter<ViewModel> {
        fun obtainDocumentInfoModel(barcodeValue: String)
    }

    interface Listener : MvpInteractor.Listener {
        fun onObtainDocumentInfoModel(documentInfoModel: DocumentInfo)
    }

    interface Interactor : MvpInteractor<Listener> {
        fun searchBarcodeValue(barcodeValue: String)
    }

    interface RouterListener : MvpRouter.Listener

    interface Router : MvpRouter<RouterListener>
}