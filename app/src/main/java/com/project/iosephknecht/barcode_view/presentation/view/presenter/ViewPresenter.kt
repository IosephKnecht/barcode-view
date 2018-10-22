package com.project.iosephknecht.barcode_view.presentation.view.presenter

import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import com.project.iosephknecht.barcode_view.viper.presenter.AbstractPresenter

class ViewPresenter(private val interactor: ViewContract.Interactor) : AbstractPresenter<ViewContract.ViewModel>(),
    ViewContract.Presenter, ViewContract.Listener {

    override fun obtainModel(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onObtainModel(modelArray: ByteArray) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}