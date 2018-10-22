package com.project.iosephknecht.barcode_view.presentation.bookmark.router

import com.project.iosephknecht.barcode_view.R
import com.project.iosephknecht.barcode_view.presentation.bookmark.BookmarkContract
import com.project.iosephknecht.barcode_view.presentation.info.view.DocumentInfoFragment
import com.project.iosephknecht.barcode_view.viper.router.AbstractRouter
import com.project.iosephknecht.barcode_view.viper.view.AndroidComponent

class BookmarkRouter : AbstractRouter<BookmarkContract.RouterListener>(), BookmarkContract.Router {
    override fun showInfoFragment(androidComponent: AndroidComponent, id: Long) {
        // TODO: router error
//        androidComponent.fragmentManagerComponent.apply {
//            val fragment = findFragmentByTag(DocumentInfoFragment.TAG)
//            if (fragment == null) {
//                beginTransaction().replace(R.id.fragment_container,DocumentInfoFragment.)
//            }
//        }
    }
}