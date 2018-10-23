package com.project.iosephknecht.barcode_view.domain.mappers

typealias DocumentPresentationModel = com.project.iosephknecht.barcode_view.data.presentation.DocumentModel
typealias DocumentDatabaseModel = com.project.iosephknecht.barcode_view.data.database.DocumentModel

object DocumentModelMapper {
    fun toPresentation(model: DocumentDatabaseModel): DocumentPresentationModel {
        model.documentInfo
        return DocumentPresentationModel(model.id, model.documentInfoId).apply {
            codeText = model.codeText
        }
    }
}