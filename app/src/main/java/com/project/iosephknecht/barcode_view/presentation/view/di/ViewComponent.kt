package com.project.iosephknecht.barcode_view.presentation.view.di

import com.project.iosephknecht.barcode_view.presentation.view.ViewContract

interface ViewComponent {
    fun getPresenter(): ViewContract.Presenter
    fun getViewModel(): ViewContract.ViewModel
}