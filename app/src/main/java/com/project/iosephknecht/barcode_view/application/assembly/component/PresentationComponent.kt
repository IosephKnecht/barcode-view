package com.project.iosephknecht.barcode_view.application.assembly.component

import com.project.iosephknecht.barcode_view.application.assembly.module.PresentationModule
import com.project.iosephknecht.barcode_view.application.assembly.annotation.PresentationScope
import com.project.iosephknecht.barcode_view.presentation.bookmark.di.BookmarkComponent
import com.project.iosephknecht.barcode_view.presentation.bookmark.di.BookmarkModule
import com.project.iosephknecht.barcode_view.presentation.info.di.DocumentInfoComponent
import com.project.iosephknecht.barcode_view.presentation.info.di.DocumentInfoModule
import com.project.iosephknecht.barcode_view.presentation.view.di.ViewComponent
import com.project.iosephknecht.barcode_view.presentation.view.di.ViewModule
import dagger.Component

@Component(dependencies = [BusinessComponent::class], modules = [PresentationModule::class])
@PresentationScope
interface PresentationComponent {
    fun bookmarkSubmodule(bookmarkModule: BookmarkModule): BookmarkComponent
    fun documentInfoSubmodule(documentInfoModule: DocumentInfoModule): DocumentInfoComponent
    fun viewSubcomponent(viewModule: ViewModule): ViewComponent
}