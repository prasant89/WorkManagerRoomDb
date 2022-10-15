package com.prasant.workmanagerroomdb.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ccom.prasant.workmanagerroomdb.model.data.ResultData

@Database(entities = [ResultData::class], version = 1)
abstract class QuoteDatabase:RoomDatabase() {

    abstract fun quoteDao() : QuoteDao

    companion object{
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "quoteDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

}
