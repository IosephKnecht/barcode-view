package com.project.iosephknecht.barcode_view.presentation.info.presenter

import com.project.iosephknecht.barcode_view.data.presentation.DocumentInfo
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.viper.presenter.AbstractPresenter
import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent

class DocumentInfoPresenter(private val interactor: DocumentInfoContract.Interactor) : AbstractPresenter<DocumentInfoContract.ViewModel>(),
    DocumentInfoContract.Presenter, DocumentInfoContract.Listener {

    override fun attachView(viewModel: DocumentInfoContract.ViewModel, androidComponent: AndroidComponent) {
        super.attachView(viewModel, androidComponent)
        interactor.setListener(this)
    }

    override fun detachView() {
        super.detachView()
    }

    override fun destroy() {
        super.destroy()
    }

    override fun obtainDocumentInfoModel(barcodeValue: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onObtainDocumentInfoModel(documentInfoModel: DocumentInfo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}