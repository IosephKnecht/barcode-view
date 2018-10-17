package com.project.iosephknecht.barcode_view.viper.presenter

import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent
import com.project.iosephknecht.barcode_view.viper.viewModel.MvpViewModel

interface MvpPresenter<VM : MvpViewModel> {
    fun attachView(viewModel: VM, androidComponent: AndroidComponent)
    fun detachView()
    fun destroy()
    var viewModel: VM?
    var androidComponent: AndroidComponent?
}