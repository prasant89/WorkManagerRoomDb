package com.prasant.workmanagerroomdb

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import ccom.prasant.workmanagerroomdb.model.api.QuoteService
import com.prasant.workmanagerroomdb.model.api.RetrofitCall
import com.prasant.workmanagerroomdb.model.db.QuoteDatabase
import com.prasant.workmanagerroomdb.model.repo.QuoteRepository
import com.prasant.workmanagerroomdb.model.worker.QuoteWorker
import java.util.concurrent.TimeUnit


class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
        setUpWorker()
    }

    private  fun setUpWorker(){
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workerRequest = PeriodicWorkRequest.Builder(QuoteWorker::class.java,15,TimeUnit.MINUTES)
            .setConstraints(constraint)
            .build()
        WorkManager.getInstance(this).enqueue(workerRequest)
    }
    private fun initialize() {
        val quoteService = RetrofitCall.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}