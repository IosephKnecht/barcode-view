package com.project.iosephknecht.barcode_view.application.assembly.component

import android.content.Context
import com.project.iosephknecht.barcode_view.application.assembly.module.AppModule
import com.project.iosephknecht.barcode_view.application.assembly.annotation.AppScope
import com.project.iosephknecht.barcode_view.data.database.DaoSession
import dagger.Component

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent {
    fun getContext(): Context
    fun getDaoSession(): DaoSession
}