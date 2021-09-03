package com.hoony.kr.sqlite1

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

class TestProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        var helper = DBHelper(context!!)
        var db = helper.writableDatabase

        return db.delete("TestTable", selection, selectionArgs)
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        var helper = DBHelper(context!!)
        var db = helper.writableDatabase

        db.insert("TestTable", null, values)
        return uri
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        var helper = DBHelper(context!!)
        var db = helper.writableDatabase

        return db.query("TestTable", projection, selection, selectionArgs, null, null, sortOrder)

    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        var helper = DBHelper(context!!)
        var db = helper.writableDatabase

        return db.update("TestTable", values, selection, selectionArgs)
    }
}