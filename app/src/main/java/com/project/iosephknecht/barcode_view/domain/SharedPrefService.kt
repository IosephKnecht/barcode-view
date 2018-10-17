package com.project.iosephknecht.barcode_view.domain

import android.content.Context
import com.google.gson.Gson
import com.project.iosephknecht.barcode_view.data.presentation.Bookmark

class SharedPrefService(applicationContext: Context,
                        private val gson: Gson) {

    private val BOOKMARK_PREF_NAME = "handbook_bookmark_pref"
    private val BOOKMARK_PREF_KEY = "bookmark"

    private val bookmarksInfoFile = applicationContext.getSharedPreferences(BOOKMARK_PREF_NAME, Context.MODE_PRIVATE)

    fun saveBookmark(bookmark: Bookmark) {
        val bookmarkString = gson.toJson(bookmark, Bookmark::class.java)
        bookmarksInfoFile.edit().putString("$BOOKMARK_PREF_KEY = ${bookmark.id}", bookmarkString).apply()
    }

    fun removeBookmark(bookMarkId: Long) {
        bookmarksInfoFile.edit().remove("$BOOKMARK_PREF_KEY = $bookMarkId").apply()
    }

    fun getBookmarkList(): List<Bookmark> {
        return bookmarksInfoFile.all
            .values
            .map { gson.fromJson(it as String, Bookmark::class.java) }
    }
}