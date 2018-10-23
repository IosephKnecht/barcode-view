package com.project.iosephknecht.barcode_view.presentation.view.presenter

import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import com.project.iosephknecht.barcode_view.viper.presenter.AbstractPresenter
import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent

class ViewPresenter(private val interactor: ViewContract.Interactor) : AbstractPresenter<ViewContract.ViewModel>(),
    ViewContract.Presenter, ViewContract.Listener {

    override fun attachView(viewModel: ViewContract.ViewModel, androidComponent: AndroidComponent) {
        super.attachView(viewModel, androidComponent)
        interactor.setListener(this)
    }

    override fun obtainModel(id: Long) {
        interactor.getModel(id)
    }

    override fun onObtainModel(modelArray: ByteArray) {
        viewModel!!.modelArray = modelArray
    }
}