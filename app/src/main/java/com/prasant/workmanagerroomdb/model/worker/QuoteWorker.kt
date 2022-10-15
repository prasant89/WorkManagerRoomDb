package com.prasant.workmanagerroomdb.model.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.prasant.workmanagerroomdb.QuoteApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteWorker(private val context:Context,param:WorkerParameters):Worker(context,param) {
    override fun doWork(): Result {
        Log.d("Worker Example","Worker Called")
        val repository =(context as QuoteApplication).quoteRepository
        CoroutineScope(Dispatchers.IO).launch{
             repository.getQuotesBackground()
        }
        return  Result.success()
    }
}