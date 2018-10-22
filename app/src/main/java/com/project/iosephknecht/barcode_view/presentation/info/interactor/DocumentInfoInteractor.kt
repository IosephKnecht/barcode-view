package com.project.iosephknecht.barcode_view.presentation.info.interactor

import com.project.iosephknecht.barcode_view.domain.DatabaseService
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.viper.interactor.AbstractInteractor

class DocumentInfoInteractor(private val databaseService: DatabaseService) : AbstractInteractor<DocumentInfoContract.Listener>(),
    DocumentInfoContract.Interactor {

    override fun searchBarcodeValue(barcodeValue: String) {

    }
}