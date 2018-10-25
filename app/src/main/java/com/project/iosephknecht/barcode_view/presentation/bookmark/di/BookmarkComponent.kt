package com.project.iosephknecht.barcode_view.presentation.bookmark.di

import com.project.iosephknecht.barcode_view.application.assembly.annotation.ModuleScope
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import dagger.Subcomponent

@ModuleScope
@Subcomponent(modules = [BookmarkModule::class])
interface BookmarkComponent {
    fun getPresenter(): BookmarkContract.Presenter
    fun getViewModel(): BookmarkContract.ViewModel
}