package com.project.iosephknecht.barcode_view.presentation.info.interactor

import com.project.iosephknecht.barcode_view.domain.mappers.DocumentInfoMapper
import com.project.iosephknecht.barcode_view.domain.services.DatabaseService
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.viper.interactor.AbstractInteractor

class DocumentInfoInteractor(private val databaseService: DatabaseService) : AbstractInteractor<DocumentInfoContract.Listener>(),
    DocumentInfoContract.Interactor {

    override fun searchBarcodeValue(barcodeValue: String) {
        discardResult(databaseService.searchDocumentModel(barcodeValue)) { listener, result ->
            result.data {
                listener!!.onObtainDocumentInfoModel(DocumentInfoMapper.toPresentation(this!!.documentInfo, this.id))
            }
        }
    }
}