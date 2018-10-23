package com.project.iosephknecht.barcode_view.presentation.info.viewModel

import android.databinding.Bindable
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.viper.viewModel.AbstractViewModel
import com.project.iosephknecht.barcode_view.BR

class DocumentInfoViewModel : AbstractViewModel(), DocumentInfoContract.ViewModel {
    override var state = DocumentInfoContract.State.IDLE

    override var rootId: Long = -1

    override var description: String = ""
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }
}