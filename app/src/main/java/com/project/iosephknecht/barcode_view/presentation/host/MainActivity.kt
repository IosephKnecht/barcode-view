package com.project.iosephknecht.barcode_view.presentation.host

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.iosephknecht.barcode_view.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val fragment = fragmentManager!!.findFragmentByTag(HostFragment.TAG)

        if (fragment == null) {
            supportFragmentManager!!.beginTransaction()
                .replace(R.id.fragment_container, HostFragment.newInstance())
                .commit()
        }
    }
}
