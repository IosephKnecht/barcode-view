package com.project.iosephknecht.barcode_view.viper.view

import com.project.iosephknecht.barcode_view.viper.viewModel.MvpViewModel

interface MvpView<VM : MvpViewModel> : AndroidComponent {
    val viewModel: VM
}