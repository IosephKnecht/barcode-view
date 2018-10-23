package com.project.iosephknecht.barcode_view.presentation.host

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.vision.barcode.Barcode
import com.project.iosephknecht.barcode_reader.BarcodeCaptureActivity
import com.project.iosephknecht.barcode_reader.RequestCode
import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.presentation.info.view.DocumentInfoFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_host.*

class HostFragment : Fragment() {

    private val BARCODE_REQUEST_CODE = 22134

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
            val fragment = fragmentManager!!.findFragmentByTag(DocumentInfoFragment.TAG)
            if (fragment == null) {
                val barcode = data!!.getParcelableExtra<Barcode>(BarcodeCaptureActivity.BarcodeObject)

                fragmentManager!!.beginTransaction()
                    .replace(R.id.fragment_container, DocumentInfoFragment.newInstance(barcode.displayValue),
                        DocumentInfoFragment.TAG)
                    .addToBackStack(null)
                    .commit()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}