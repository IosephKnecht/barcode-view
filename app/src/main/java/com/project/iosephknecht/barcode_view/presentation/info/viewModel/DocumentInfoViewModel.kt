package com.project.iosephknecht.barcode_view.presentation.info.viewModel

import android.databinding.Bindable
import com.project.iosephknecht.barcode_view.BR
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.viper.viewModel.AbstractViewModel

class DocumentInfoViewModel : AbstractViewModel(), DocumentInfoContract.ViewModel {
    override var description: String = ""
        @Bindable get() = field
        set(value) {
            field = value
            //notifyPropertyChanged(BR.description)
        }
    override var modelArray = byteArrayOf()
}