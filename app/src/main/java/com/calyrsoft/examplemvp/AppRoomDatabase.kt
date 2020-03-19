package com.calyrsoft.examplemvp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = arrayOf(Book::class), version = 1, exportSchema = false)
abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun bookDato(): IBookDao

    companion object {
        private var INSTANCE : AppRoomDatabase? = null

        fun getDatabase(context: Context) : AppRoomDatabase {
            val tempInstance = INSTANCE
            if ( tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, AppRoomDatabase::class.java, "db_name").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
