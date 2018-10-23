package com.project.iosephknecht.barcode_view.presentation.info.presenter

import com.project.iosephknecht.barcode_view.data.presentation.DocumentInfo
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.viper.presenter.AbstractPresenter
import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent

class DocumentInfoPresenter(private val interactor: DocumentInfoContract.Interactor,
                            private val router: DocumentInfoContract.Router) : AbstractPresenter<DocumentInfoContract.ViewModel>(),
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
        interactor.searchBarcodeValue(barcodeValue)
    }

    override fun jumpToViewFragment(rootId: Long) {
        router.showView(androidComponent!!, rootId)
    }

    override fun onObtainDocumentInfoModel(documentInfoModel: DocumentInfo) {
        viewModel!!.description = documentInfoModel.description!!
        viewModel!!.rootId = documentInfoModel.rootId
    }
}