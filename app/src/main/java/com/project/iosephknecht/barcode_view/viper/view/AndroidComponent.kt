package com.project.iosephknecht.barcode_view.viper.view

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

interface AndroidComponent {
    val activityComponent: AppCompatActivity
    val fragmentManagerComponent: FragmentManager
}