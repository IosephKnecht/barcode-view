package com.project.iosephknecht.barcode_view.presentation.info.di

import com.project.iosephknecht.barcode_view.application.assembly.annotation.ModuleScope
import com.project.iosephknecht.barcode_view.domain.services.DatabaseService
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.presentation.info.interactor.DocumentInfoInteractor
import com.project.iosephknecht.barcode_view.presentation.info.presenter.DocumentInfoPresenter
import com.project.iosephknecht.barcode_view.presentation.info.router.DocumentInfoRouter
import com.project.iosephknecht.barcode_view.presentation.info.viewModel.DocumentInfoViewModel
import dagger.Module
import dagger.Provides

@Module
class DocumentInfoModule {

    @Provides
    @ModuleScope
    fun provideViewModel(): DocumentInfoContract.ViewModel {
        return DocumentInfoViewModel()
    }

    @Provides
    @ModuleScope
    fun providePresenter(interactor: DocumentInfoContract.Interactor,
                         router: DocumentInfoContract.Router): DocumentInfoContract.Presenter {
        return DocumentInfoPresenter(interactor, router)
    }

    @Provides
    @ModuleScope
    fun provideInteractor(databaseService: DatabaseService): DocumentInfoContract.Interactor {
        return DocumentInfoInteractor(databaseService)
    }

    @Provides
    @ModuleScope
    fun provideRouter(): DocumentInfoContract.Router {
        return DocumentInfoRouter()
    }
}