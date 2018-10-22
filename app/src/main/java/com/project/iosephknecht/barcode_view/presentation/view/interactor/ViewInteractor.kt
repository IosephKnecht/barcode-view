package com.project.iosephknecht.barcode_view.presentation.view.interactor

import com.project.iosephknecht.barcode_view.domain.DatabaseService
import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import com.project.iosephknecht.barcode_view.viper.interactor.AbstractInteractor

class ViewInteractor(private val databaseService: DatabaseService) : AbstractInteractor<ViewContract.Listener>(),
    ViewContract.Interactor {

    override fun getModel(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}