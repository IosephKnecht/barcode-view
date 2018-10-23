package com.project.iosephknecht.barcode_view.application.assembly.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.project.iosephknecht.barcode_view.application.assembly.annotation.BusinessScope
import com.project.iosephknecht.barcode_view.data.database.DaoSession
import com.project.iosephknecht.barcode_view.domain.services.DatabaseService
import com.project.iosephknecht.barcode_view.domain.services.SharedPrefService
import dagger.Module
import dagger.Provides

@Module
class BusinessModule {

    @Provides
    @BusinessScope
    fun provideDatabaseService(daoSession: DaoSession): DatabaseService {
        return DatabaseService(daoSession)
    }

    @Provides
    @BusinessScope
    fun provideSharedPrefService(context: Context, gson: Gson): SharedPrefService {
        return SharedPrefService(context, gson)
    }

    @Provides
    @BusinessScope
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
}