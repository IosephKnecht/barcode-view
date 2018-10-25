package com.project.iosephknecht.barcode_view.viper.router

interface MvpRouter<L : MvpRouter.Listener> {
    fun setListener(listener: L?)

    interface Listener
}