package com.project.iosephknecht.barcode_view.data.presentation

data class DocumentModel(val id: Long,
                         val documentInfoId: Long,
                         var codeText: String? = null)