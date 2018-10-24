package com.project.iosephknecht.barcode_view.presentation.info.interactor

import com.project.iosephknecht.barcode_view.data.presentation.Bookmark
import com.project.iosephknecht.barcode_view.domain.mappers.DocumentInfoMapper
import com.project.iosephknecht.barcode_view.domain.services.DatabaseService
import com.project.iosephknecht.barcode_view.domain.services.SharedPrefService
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.viper.interactor.AbstractInteractor
import io.reactivex.Observable

class DocumentInfoInteractor(private val databaseService: DatabaseService,
                             private val sharedPrefService: SharedPrefService) : AbstractInteractor<DocumentInfoContract.Listener>(),
        DocumentInfoContract.Interactor {

    override fun searchBarcodeValue(barcodeValue: String) {
        discardResult(databaseService.searchDocumentModel(barcodeValue)) { listener, result ->
            result.data {
                listener!!.onObtainDocumentInfoModel(DocumentInfoMapper.toPresentation(this!!.documentInfo, this.id))
            }
        }
    }

    override fun saveBookmark(bookamrk: Bookmark) {
        discardResult(Observable.fromCallable { sharedPrefService.saveBookmark(bookamrk) }) { listener, result ->
            result.data { listener!!.onSaveBookmark(true) }
            result.throwable { listener!!.onSaveBookmark(false) }
        }
    }
}