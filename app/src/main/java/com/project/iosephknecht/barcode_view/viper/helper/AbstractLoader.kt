package com.project.iosephknecht.barcode_view.viper.helper

import android.content.Context
import android.support.v4.content.Loader
import com.project.iosephknecht.barcode_view.viper.presenter.MvpPresenter
import com.project.iosephknecht.barcode_view.viper.viewModel.MvpViewModel

class AbstractLoader<VM : MvpViewModel, Presenter : MvpPresenter<VM>>(context: Context,
                                                                      private val presenter: Presenter)
    : Loader<Presenter>(context) {

    var savePresenter: Presenter?
        private set

    init {
        savePresenter = presenter
    }

    override fun onStartLoading() {
        super.onStartLoading()
        deliverResult(savePresenter)
    }

    override fun onReset() {
        super.onReset()
        savePresenter?.destroy()
        savePresenter = null
    }
}