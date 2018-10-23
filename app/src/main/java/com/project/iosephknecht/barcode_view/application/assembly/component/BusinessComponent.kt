package com.project.iosephknecht.barcode_view.application.assembly.component

import com.project.iosephknecht.barcode_view.application.assembly.module.BusinessModule
import com.project.iosephknecht.barcode_view.application.assembly.annotation.BusinessScope
import com.project.iosephknecht.barcode_view.domain.services.DatabaseService
import com.project.iosephknecht.barcode_view.domain.services.SharedPrefService
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [BusinessModule::class])
@BusinessScope
interface BusinessComponent {
    fun getDatabaseService(): DatabaseService
    fun getSharedPrefService(): SharedPrefService
}