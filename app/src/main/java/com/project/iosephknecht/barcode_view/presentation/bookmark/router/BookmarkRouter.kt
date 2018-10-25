package com.project.iosephknecht.barcode_view.presentation.bookmark.router

import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.presentation.info.view.DocumentInfoFragment
import com.project.iosephknecht.barcode_view.presentation.view.view.ViewFragment
import com.project.iosephknecht.barcode_view.viper.router.AbstractRouter
import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent

class BookmarkRouter : AbstractRouter<BookmarkContract.RouterListener>(), BookmarkContract.Router {
    override fun showInfoFragment(androidComponent: AndroidComponent, id: Long) {
        androidComponent.fragmentManagerComponent.apply {
            val fragment = findFragmentByTag(ViewFragment.TAG)
            if (fragment == null) {
                beginTransaction()
                        .replace(R.id.fragment_container, ViewFragment.newInstance(id), ViewFragment.TAG)
                        .addToBackStack(null)
                        .commit()
            }
        }
    }
}