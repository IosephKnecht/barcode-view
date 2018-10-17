package com.project.iosephknecht.barcode_view.viper.router

abstract class AbstractRouter<L : MvpRouter.Listener> : MvpRouter<L> {
    var routerListener: L? = null

    override fun setListener(listener: L?) {
        this.routerListener = listener
    }
}