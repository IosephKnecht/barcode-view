package com.project.iosephknecht.barcode_view.viper.interactor

interface MvpInteractor<L : MvpInteractor.Listener> {
    interface Listener {

    }

    fun setListener(presenter: L?)
    fun onDestroy()
}