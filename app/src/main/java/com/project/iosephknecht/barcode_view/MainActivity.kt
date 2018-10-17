package com.project.iosephknecht.barcode_view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.project.iosephknecht.barcode_reader.BarcodeCaptureActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val BARCODE_REQUEST_CODE = 221347

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        scan_button.setOnClickListener { startActivityForResult(createIntent(), BARCODE_REQUEST_CODE) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == BARCODE_REQUEST_CODE && resultCode == 1) {
            // TODO: jump to documentScreenModule
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun createIntent() = Intent(this, BarcodeCaptureActivity::class.java)
        .apply {
            putExtra(BarcodeCaptureActivity.AutoFocus, true)
            putExtra(BarcodeCaptureActivity.UseFlash, false)
        }
}
