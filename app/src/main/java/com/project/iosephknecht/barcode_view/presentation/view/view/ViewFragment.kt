package com.project.iosephknecht.barcode_view.presentation.view.view

import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.application.AppDelegate
import com.project.iosephknecht.barcode_view.databinding.FragmentViewBinding
import com.project.iosephknecht.barcode_view.presentation.view.ViewContract
import com.project.iosephknecht.barcode_view.presentation.view.di.ViewComponent
import com.project.iosephknecht.barcode_view.presentation.view.di.ViewModule
import com.project.iosephknecht.barcode_view.viper.view.AbstractFragment
import com.project.iosephknecht.barcode_view.BR
import kotlinx.android.synthetic.main.fragment_view.*

class ViewFragment : AbstractFragment<ViewContract.ViewModel, ViewContract.Presenter>() {

    companion object {
        const val TAG = "view_fragment"
        private const val DOCUMENT_MODEL_ID = "document_model_id"

        fun newInstance(id: Long) = ViewFragment().apply {
            arguments = Bundle().apply {
                putLong(DOCUMENT_MODEL_ID, id)
            }
        }
    }

    private lateinit var diComponent: ViewComponent
    private lateinit var bindingComponent: FragmentViewBinding

    override fun injectDi() {
        diComponent = AppDelegate.presentationComponent
            .viewSubcomponent(ViewModule(context!!))
    }

    override fun createPresenter() = diComponent.getPresenter()

    override fun createViewModel() = diComponent.getViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingComponent = DataBindingUtil.inflate(inflater, R.layout.fragment_view, container, false)
        return bindingComponent.root
    }

    override fun onStart() {
        super.onStart()

        bindingComponent.viewModel = viewModel!!

        viewModel!!.addOnPropertyChangedCallback(vmObserver)

        val rootId = arguments?.getLong(DOCUMENT_MODEL_ID, -1)

        if (rootId != -1L) presenter!!.obtainModel(rootId!!)
    }

    override fun onStop() {
        view_container.removeAllViews()
        view_container.destroyDrawingCache()
        viewModel!!.removeOnPropertyChangedCallback(vmObserver)

        super.onStop()
    }

    private val vmObserver: Observable.OnPropertyChangedCallback by lazy {
        object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when (propertyId) {
                    BR.modelArray -> {
                        with(diComponent.getViewer().getFacade()) {
                            view_container.addView(buildSurfaceView(buildModel(viewModel!!.modelArray.inputStream()),
                                buildFloor(), buildLight()))
                        }
                    }
                }
            }
        }
    }
}