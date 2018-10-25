package com.project.iosephknecht.barcode_view.presentation.info.di

import com.project.iosephknecht.barcode_view.application.assembly.annotation.ModuleScope
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import dagger.Subcomponent

@ModuleScope
@Subcomponent(modules = [DocumentInfoModule::class])
interface DocumentInfoComponent {
    fun getPresenter(): DocumentInfoContract.Presenter
    fun getViewModel(): DocumentInfoContract.ViewModel
}