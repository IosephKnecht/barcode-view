package com.project.iosephknecht.barcode_view.presentation.view.interactor

import com.project.iosephknecht.barcode_view.domain.services.DatabaseService
import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import com.project.iosephknecht.barcode_view.viper.interactor.AbstractInteractor

class ViewInteractor(private val databaseService: DatabaseService) : AbstractInteractor<ViewContract.Listener>(),
    ViewContract.Interactor {

    override fun getModel(id: Long) {

        discardResult(databaseService.documentModel(id)) { listener, result ->
            result.data { listener!!.onObtainModel(this!!.modelArray) }
        }
    }
}