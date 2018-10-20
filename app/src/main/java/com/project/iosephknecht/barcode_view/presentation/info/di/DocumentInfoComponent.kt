package com.project.iosephknecht.barcode_view.presentation.info.di

import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract

interface DocumentInfoComponent {
    fun getPresenter(): DocumentInfoContract.Presenter
    fun getViewModel(): DocumentInfoContract.ViewModel
}