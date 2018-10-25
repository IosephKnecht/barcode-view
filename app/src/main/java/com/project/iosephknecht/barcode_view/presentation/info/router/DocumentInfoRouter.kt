package com.project.iosephknecht.barcode_view.presentation.info.router

import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.presentation.bookmark.view.BookmarkFragment
import com.project.iosephknecht.barcode_view.presentation.info.DocumentInfoContract
import com.project.iosephknecht.barcode_view.presentation.view.view.ViewFragment
import com.project.iosephknecht.barcode_view.viper.router.AbstractRouter
import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent

class DocumentInfoRouter : AbstractRouter<DocumentInfoContract.RouterListener>(),
        DocumentInfoContract.Router {

    override fun showView(androidComponent: AndroidComponent, rootId: Long) {
        androidComponent.fragmentManagerComponent.apply {
            val fragment = findFragmentByTag(ViewFragment.TAG)
            if (fragment == null) {
                beginTransaction()
                        .replace(R.id.fragment_container, ViewFragment.newInstance(rootId), ViewFragment.TAG)
                        .addToBackStack(null)
                        .commit()
            }
        }
    }

    override fun showBookmarkList(androidComponent: AndroidComponent) {
        androidComponent.fragmentManagerComponent.apply {
            val fragment = findFragmentByTag(BookmarkFragment.TAG)
            if (fragment == null) {
                beginTransaction()
                        .replace(R.id.fragment_container, BookmarkFragment.newInstance(), BookmarkFragment.TAG)
                        .addToBackStack(null)
                        .commit()
            }
        }
    }
}