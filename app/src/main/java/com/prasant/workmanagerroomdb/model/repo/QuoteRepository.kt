package com.prasant.workmanagerroomdb.model.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ccom.prasant.workmanagerroomdb.model.api.QuoteService
import com.prasant.workmanagerroomdb.model.data.QuoteList
import com.prasant.workmanagerroomdb.model.db.QuoteDatabase
import com.prasant.workmanagerroomdb.model.utils.NetworkUtils

class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuotes(page: Int){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes(page)
            if(result?.body() != null){
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,1,1,quotes, 1, 1)
            quotesLiveData.postValue(quoteList)
        }
    }

    suspend fun getQuotesBackground(){
        val randomNum = (Math.random()*10).toInt()
        val result = quoteService.getQuotes(randomNum)
        if(result?.body() !=null){
            quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
        }
    }
}