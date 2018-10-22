package com.project.iosephknecht.barcode_view.domain.mappers


typealias DocumentInfoPresentation = com.project.iosephknecht.barcode_view.data.presentation.DocumentInfo
typealias DocumentInfoDatabase = com.project.iosephknecht.barcode_view.data.database.DocumentInfo

object DocumentInfoMapper {
    fun toPresentation(model: DocumentInfoDatabase, rootId: Long): DocumentInfoPresentation {
        return DocumentInfoPresentation(model.id, rootId ,model.description)
    }
}