package com.project.iosephknecht.barcode_view.presentation.host

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.iosephknecht.barcode_reader.BarcodeCaptureActivity
import com.project.iosephknecht.barcode_reader.RequestCode
import com.project.iosephknecht.barcode_view.R
import kotlinx.android.synthetic.main.fragment_host.*

class HostFragment : Fragment() {

    private val BARCODE_REQUEST_CODE = 221347

    companion object {
        const val TAG = "host_fragment"

        fun newInstance() = HostFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_host, container, false)
    }

    override fun onStart() {
        super.onStart()

        scan_button.setOnClickListener { startActivityForResult(createIntent(), BARCODE_REQUEST_CODE) }
    }

    private fun createIntent() = Intent(context, BarcodeCaptureActivity::class.java)
        .apply {
            putExtra(BarcodeCaptureActivity.AutoFocus, true)
            putExtra(BarcodeCaptureActivity.UseFlash, false)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == BARCODE_REQUEST_CODE && resultCode == RequestCode.SUCCESS) {
            // TODO: jump to documentScreenModule
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}