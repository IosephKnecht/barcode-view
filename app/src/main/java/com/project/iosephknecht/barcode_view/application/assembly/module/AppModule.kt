package com.project.iosephknecht.barcode_view.application.assembly.module

import android.content.Context
import com.project.iosephknecht.barcode_view.application.assembly.annotation.AppScope
import com.project.iosephknecht.barcode_view.data.database.DaoSession
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context,
                private val daoSession: DaoSession) {
    @Provides
    @AppScope
    fun getContext() = context

    @Provides
    @AppScope
    fun getDaoSession() = daoSession
}