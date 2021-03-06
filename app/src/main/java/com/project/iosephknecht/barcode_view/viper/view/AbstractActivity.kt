package com.project.iosephknecht.barcode_view.viper.view

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v7.app.AppCompatActivity
import com.project.iosephknecht.barcode_view.viper.helper.AbstractLoader
import com.project.iosephknecht.barcode_view.viper.presenter.MvpPresenter
import com.project.iosephknecht.barcode_view.viper.viewModel.MvpViewModel
import java.util.*

abstract class AbstractActivity<VM : MvpViewModel, Presenter : MvpPresenter<VM>>
    : AppCompatActivity(), AndroidComponent, LoaderManager.LoaderCallbacks<Presenter> {

    private lateinit var LOADER_ID: UUID

    override val activityComponent: AppCompatActivity
        get() = this
    override val fragmentManagerComponent: FragmentManager
        get() = supportFragmentManager

    var presenter: Presenter? = null
        protected set
    var viewModel: VM? = null
        protected set

    abstract fun injectDi()
    abstract fun createPresenter(): Presenter
    abstract fun createViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            LOADER_ID = UUID.randomUUID()
        } else {
            LOADER_ID = UUID.fromString(savedInstanceState.getString("RANDOM_UUID"))
        }
        injectDi()
        val loader = supportLoaderManager
            .getLoader<Presenter>(LOADER_ID.hashCode())
        if (loader == null) {
            supportLoaderManager.initLoader(LOADER_ID.hashCode(), null, this)
            presenter = createPresenter()
            viewModel = createViewModel()
        } else {
            presenter = (loader as AbstractLoader<VM, Presenter>).savePresenter
            viewModel = presenter!!.viewModel
        }
    }

    override fun onStart() {
        super.onStart()
        if (viewModel != null)
            presenter?.attachView(viewModel!!, this)
    }

    override fun onStop() {
        super.onStop()
        presenter?.detachView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("RANDOM_UUID", LOADER_ID.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
        presenter = null
        viewModel = null
    }

    final override fun onCreateLoader(id: Int, args: Bundle?): Loader<Presenter> {
        val loader = AbstractLoader(this, createPresenter())
        return loader
    }

    final override fun onLoadFinished(loader: Loader<Presenter>, data: Presenter) {
    }

    final override fun onLoaderReset(loader: Loader<Presenter>) {
    }
}