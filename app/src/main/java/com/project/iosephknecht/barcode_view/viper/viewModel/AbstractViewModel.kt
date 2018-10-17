package com.project.iosephknecht.barcode_view.viper.viewModel

import android.databinding.BaseObservable
import java.util.*

abstract class AbstractViewModel() : BaseObservable(), MvpViewModel {
    final override var vmId: String

    init {
        vmId = UUID.randomUUID().toString()
    }

    constructor(vmId: String) : this() {
        this.vmId = vmId
    }
}