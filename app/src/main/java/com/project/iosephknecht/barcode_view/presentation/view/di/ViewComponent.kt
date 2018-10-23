package com.project.iosephknecht.barcode_view.presentation.view.di

import com.project.iosephknecht.barcode_view.application.assembly.annotation.ModuleScope
import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import dagger.Subcomponent

@ModuleScope
@Subcomponent(modules = [ViewModule::class])
interface ViewComponent {
    fun getPresenter(): ViewContract.Presenter
    fun getViewModel(): ViewContract.ViewModel
}