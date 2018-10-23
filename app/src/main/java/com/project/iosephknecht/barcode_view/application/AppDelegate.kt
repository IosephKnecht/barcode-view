package com.project.iosephknecht.barcode_view.application

import android.support.multidex.MultiDexApplication
import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.application.assembly.component.*
import com.project.iosephknecht.barcode_view.application.assembly.module.AppModule
import com.project.iosephknecht.barcode_view.application.assembly.module.BusinessModule
import com.project.iosephknecht.barcode_view.application.assembly.module.PresentationModule
import com.project.iosephknecht.barcode_view.data.database.DaoMaster
import com.project.iosephknecht.barcode_view.data.database.DaoSession
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


class AppDelegate : MultiDexApplication() {

    private lateinit var daoSession: DaoSession
    private val DATABASE_NAME = "barcodeview_db"

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var presentationComponent: PresentationComponent
        lateinit var businessComponent: BusinessComponent
    }

    override fun onCreate() {
        super.onCreate()

        initDatabase()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this, daoSession))
            .build()

        businessComponent = DaggerBusinessComponent.builder()
            .appComponent(appComponent)
            .businessModule(BusinessModule())
            .build()

        presentationComponent = DaggerPresentationComponent.builder()
            .businessComponent(businessComponent)
            .presentationModule(PresentationModule())
            .build()
    }

    private fun initDatabase() {
        copy(resources.openRawResource(R.raw.barcodeview_db))
        val helper = DaoMaster.DevOpenHelper(this, DATABASE_NAME)
        val database = helper.writableDatabase
        daoSession = DaoMaster(database).newSession()
    }

    //FIXME: temp solve
    private fun copy(inputStream: InputStream) {
        val outputStream = FileOutputStream(applicationInfo.dataDir + "/databases/" + DATABASE_NAME)
        val buffer = ByteArray(1024)
        var length = 0
        val line: () -> Int = {
            length = inputStream.read(buffer)
            length
        }
        while (line() > 0) {
            outputStream.write(buffer, 0, length)
        }
        outputStream.flush()
        outputStream.close()
        inputStream.close()
    }
}