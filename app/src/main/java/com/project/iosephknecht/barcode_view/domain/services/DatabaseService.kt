package com.project.iosephknecht.barcode_view.domain.services

import com.project.iosephknecht.barcode_view.data.database.DaoSession
import com.project.iosephknecht.barcode_view.data.database.DocumentModel
import com.project.iosephknecht.barcode_view.data.database.DocumentModelDao
import io.reactivex.Observable

class DatabaseService(private val daoSession: DaoSession) {
    fun searchDocumentModel(codeText: String): Observable<DocumentModel?> {
        return Observable.fromCallable { getDocumentModel(codeText) }
    }

    fun documentModel(id: Long): Observable<DocumentModel?> {
        return Observable.fromCallable { getDocumentModel(id) }
    }

    private fun getDocumentModel(id: Long): DocumentModel? {
        return daoSession.documentModelDao
            .queryBuilder()
            .where(DocumentModelDao.Properties.Id.eq(id))
            .unique()
    }

    private fun getDocumentModel(codeText: String): DocumentModel? {
        return daoSession.documentModelDao
            .queryBuilder()
            .where(DocumentModelDao.Properties.CodeText.eq(codeText))
            .unique()
    }
}