package com.prasant.workmanagerroomdb.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ccom.prasant.workmanagerroomdb.model.data.ResultData

@Dao
interface QuoteDao {
    @Insert
     fun addQuotes(quotes: List<ResultData>)

    @Query("SELECT * FROM quote")
     fun getQuotes() : List<ResultData>
}