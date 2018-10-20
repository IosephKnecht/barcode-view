package com.project.iosephknecht.barcode_view.presentation.info.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.databinding.FragmentInfoBinding
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.presentation.info.di.DocumentInfoComponent
import com.project.iosephknecht.barcode_view.viper.view.AbstractFragment
import kotlinx.android.synthetic.main.fragment_info.*

class DocumentInfoFragment : AbstractFragment<DocumentInfoContract.ViewModel, DocumentInfoContract.Presenter>() {

    private lateinit var diComponent: DocumentInfoComponent
    private lateinit var bindingComponent: FragmentInfoBinding

    companion object {
        private const val BARCODE_VALUE = "barcode_value"

        fun newInstance(barcodeValue: String) = DocumentInfoFragment().apply {
            arguments?.apply {
                putString(BARCODE_VALUE, barcodeValue)
            }
        }
    }

    override fun injectDi() {
        //diComponent =
    }

    override fun createPresenter() = diComponent.getPresenter()

    override fun createViewModel() = diComponent.getViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingComponent = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        return bindingComponent.root
    }

    override fun onStart() {
        super.onStart()

        view_btn.setOnClickListener {
            // TODO : replace on 3dViewFragment
        }
    }
}