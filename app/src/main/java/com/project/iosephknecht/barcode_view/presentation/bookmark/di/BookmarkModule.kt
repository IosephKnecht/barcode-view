package com.project.iosephknecht.barcode_view.presentation.bookmark.di

import com.project.iosephknecht.barcode_view.application.assembly.annotation.ModuleScope
import com.project.iosephknecht.barcode_view.domain.services.SharedPrefService
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.presentation.bookmark.interactor.BookmarkInteractor
import com.project.iosephknecht.barcode_view.presentation.bookmark.presenter.BookmarkPresenter
import com.project.iosephknecht.barcode_view.presentation.bookmark.router.BookmarkRouter
import com.project.iosephknecht.barcode_view.presentation.bookmark.viewModel.BookmarkViewModel
import dagger.Module
import dagger.Provides

@Module
class BookmarkModule {

    @Provides
    @ModuleScope
    fun provideViewModel(): BookmarkContract.ViewModel {
        return BookmarkViewModel()
    }

    @Provides
    @ModuleScope
    fun providePresenter(interactor: BookmarkContract.Interactor,
                         router: BookmarkContract.Router): BookmarkContract.Presenter {
        return BookmarkPresenter(interactor, router)
    }

    @Provides
    @ModuleScope
    fun provideInteractor(sharedPrefService: SharedPrefService): BookmarkContract.Interactor {
        return BookmarkInteractor(sharedPrefService)
    }

    @Provides
    @ModuleScope
    fun provideRouter(): BookmarkContract.Router {
        return BookmarkRouter()
    }

}