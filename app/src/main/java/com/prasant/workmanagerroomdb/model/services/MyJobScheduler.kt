package com.prasant.workmanagerroomdb.model.services

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.prasant.workmanagerroomdb.model.utils.scheduleJob


class MyJobScheduler : JobService() {
    private val TAG = "SyncService"
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStartJob(p0: JobParameters?): Boolean {
        val service = Intent(applicationContext, LocalWordService::class.java)
        getApplicationContext().startService(service)
        scheduleJob(getApplicationContext())

        return false
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        return false
    }

}