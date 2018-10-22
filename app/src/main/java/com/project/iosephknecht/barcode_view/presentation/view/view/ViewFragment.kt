package com.project.iosephknecht.barcode_view.presentation.view.view

import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import com.project.iosephknecht.barcode_view.presentation.view.di.ViewComponent
import com.project.iosephknecht.barcode_view.viper.view.AbstractFragment

class ViewFragment : AbstractFragment<ViewContract.ViewModel, ViewContract.Presenter>() {

    companion object {
        const val TAG = "view_fragment"
        const val DOCUMENT_MODEL_ID = "document_model_id"

        fun newInstance(id: Long) = ViewFragment().apply {
            arguments?.apply {
                putLong(DOCUMENT_MODEL_ID, id)
            }
        }
    }

    private lateinit var diComponent: ViewComponent

    override fun injectDi() {
        // diComponent =
    }

    override fun createPresenter() = diComponent.getPresenter()

    override fun createViewModel() = diComponent.getViewModel()
}