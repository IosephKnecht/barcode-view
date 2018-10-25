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

        val fragment = supportFragmentManager!!.findFragmentByTag(HostFragment.TAG)

        if (fragment == null) {
            supportFragmentManager!!.beginTransaction()
                .add(R.id.fragment_container, HostFragment.newInstance(), HostFragment.TAG)
                .addToBackStack(null)
                .commit()
        }
    }
}
