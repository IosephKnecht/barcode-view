package com.project.iosephknecht.barcode_view.presentation.info.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.*
import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.application.AppDelegate
import com.project.iosephknecht.barcode_view.databinding.FragmentInfoBinding
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.presentation.info.di.DocumentInfoComponent
import com.project.iosephknecht.barcode_view.presentation.info.di.DocumentInfoModule
import com.project.iosephknecht.barcode_view.viper.view.AbstractFragment
import kotlinx.android.synthetic.main.fragment_info.*

class DocumentInfoFragment : AbstractFragment<DocumentInfoContract.ViewModel, DocumentInfoContract.Presenter>() {

    private lateinit var diComponent: DocumentInfoComponent
    private lateinit var bindingComponent: FragmentInfoBinding

    companion object {
        private const val BARCODE_VALUE = "barcode_value"
        const val TAG = "document_fragment_info"

        fun newInstance(barcodeValue: String) = DocumentInfoFragment().apply {
            arguments = Bundle().apply {
                putString(BARCODE_VALUE, barcodeValue)
            }
        }
    }

    override fun injectDi() {
        val barcodeValue = arguments?.getString(BARCODE_VALUE, "")

        diComponent = AppDelegate.presentationComponent
                .documentInfoSubmodule(DocumentInfoModule(barcodeValue))
    }

    override fun createPresenter() = diComponent.getPresenter()

    override fun createViewModel() = diComponent.getViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingComponent = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        return bindingComponent.root
    }

    override fun onStart() {
        super.onStart()

        bindingComponent.viewModel = viewModel!!

        view_btn.setOnClickListener {
            presenter!!.jumpToViewFragment(viewModel!!.rootId)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.bookmark_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.bookmark_add_btn -> {
                presenter!!.addBookmark()
            }
            R.id.bookmark_list_dtn -> {
                presenter!!.showBookmarkList()
            }
        }

        return false
    }
}