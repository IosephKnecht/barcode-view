package com.project.iosephknecht.barcode_view.presentation.view.viewModel

import android.databinding.Bindable
import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import com.project.iosephknecht.barcode_view.viper.viewModel.AbstractViewModel
import com.project.iosephknecht.barcode_view.BR

class ViewViewModel : AbstractViewModel(), ViewContract.ViewModel {

    override var modelArray: ByteArray = byteArrayOf()
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.modelArray)
        }
}