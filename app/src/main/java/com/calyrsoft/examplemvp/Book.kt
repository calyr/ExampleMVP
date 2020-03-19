package com.calyrsoft.examplemvp

import android.icu.text.CaseMap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
class Book( @ColumnInfo(name = "title")  var title: String, var autor: String = "", var version : Int = 1) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

}