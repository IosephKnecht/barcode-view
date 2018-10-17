package com.project.iosephknecht.barcode_view.domain

import com.project.iosephknecht.barcode_view.data.database.DaoSession
import com.project.iosephknecht.barcode_view.data.database.DocumentModel
import com.project.iosephknecht.barcode_view.data.database.DocumentModelDao
import io.reactivex.Observable

class DatabaseService(private val daoSession: DaoSession) {
    fun searchDocomentModel(codeText: String): Observable<DocumentModel?> {
        return Observable.fromCallable { getDocumentModel(codeText) }
    }

    private fun getDocumentModel(codeText: String): DocumentModel? {
        return daoSession.documentModelDao
            .queryBuilder()
            .where(DocumentModelDao.Properties.CodeText.eq(codeText))
            .unique()
    }
}