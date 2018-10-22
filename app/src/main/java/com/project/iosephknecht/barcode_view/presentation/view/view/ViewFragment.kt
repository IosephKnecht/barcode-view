package com.project.iosephknecht.barcode_view.presentation.view.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.databinding.FragmentViewBinding
import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import com.project.iosephknecht.barcode_view.presentation.view.di.ViewComponent
import com.project.iosephknecht.barcode_view.viper.view.AbstractFragment

class ViewFragment : AbstractFragment<ViewContract.ViewModel, ViewContract.Presenter>() {

    companion object {
        const val TAG = "view_fragment"
        private const val DOCUMENT_MODEL_ID = "document_model_id"

        fun newInstance(id: Long) = ViewFragment().apply {
            arguments?.apply {
                putLong(DOCUMENT_MODEL_ID, id)
            }
        }
    }

    private lateinit var diComponent: ViewComponent
    private lateinit var bindingComponent: FragmentViewBinding

    override fun injectDi() {
        // diComponent =
    }

    override fun createPresenter() = diComponent.getPresenter()

    override fun createViewModel() = diComponent.getViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingComponent = DataBindingUtil.inflate(inflater, R.layout.fragment_view, container, false)
        return bindingComponent.root
    }

    override fun onStart() {
        super.onStart()

        val rootId = arguments?.getLong(DOCUMENT_MODEL_ID, -1)

        if (rootId != -1L) presenter!!.obtainModel(rootId!!)
    }
}