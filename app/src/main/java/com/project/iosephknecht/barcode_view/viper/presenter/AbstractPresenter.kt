package com.project.iosephknecht.barcode_view.viper.presenter

import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent
import com.project.iosephknecht.barcode_view.viper.viewModel.MvpViewModel

abstract class AbstractPresenter<VM : MvpViewModel> : MvpPresenter<VM> {
    final override var viewModel: VM? = null
    final override var androidComponent: AndroidComponent? = null

    override fun attachView(viewModel: VM, androidComponent: AndroidComponent) {
        this.viewModel = viewModel
        this.androidComponent = androidComponent
    }

    override fun detachView() {
        androidComponent = null
    }

    override fun destroy() {
    }
}