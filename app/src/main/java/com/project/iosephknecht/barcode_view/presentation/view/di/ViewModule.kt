package com.project.iosephknecht.barcode_view.presentation.view.di

import android.content.Context
import com.example.aamezencev.a3dviewer.di.DaggerViewerComponent
import com.example.aamezencev.a3dviewer.di.ViewerComponent
import com.project.iosephknecht.barcode_view.application.assembly.annotation.ModuleScope
import com.project.iosephknecht.barcode_view.domain.services.DatabaseService
import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import com.project.iosephknecht.barcode_view.presentation.view.interactor.ViewInteractor
import com.project.iosephknecht.barcode_view.presentation.view.presenter.ViewPresenter
import com.project.iosephknecht.barcode_view.presentation.view.viewModel.ViewViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModule(private val context: Context,
                 private val rootId: Long?) {

    @Provides
    @ModuleScope
    fun provideViewModel(): ViewContract.ViewModel {
        return ViewViewModel()
    }

    @Provides
    @ModuleScope
    fun providePresenter(interactor: ViewContract.Interactor): ViewContract.Presenter {
        return ViewPresenter(interactor, rootId)
    }

    @Provides
    @ModuleScope
    fun provideInteractor(databaseService: DatabaseService): ViewContract.Interactor {
        return ViewInteractor(databaseService)
    }

    @Provides
    @ModuleScope
    fun provideViewerLibrary(): ViewerComponent {
        return DaggerViewerComponent
            .builder()
            .viewerModule(com.example.aamezencev.a3dviewer.di.ViewerModule(context))
            .build()
    }
}