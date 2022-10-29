package com.prasant.workmanagerroomdb

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prasant.workmanagerroomdb.model.services.MyJobScheduler

class MainActivity : AppCompatActivity() {

    val JOB_ID = 1001;
    val REFRESH_INTERVAL  : Long = 15 * 60 * 1000 // 15 minutes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scheduleJob()
    }
    private fun scheduleJob(){
        val jobScheduler = applicationContext.getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
        val componentName = ComponentName(this, MyJobScheduler::class.java)
        val jobInfo = JobInfo.Builder(JOB_ID, componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setPeriodic(REFRESH_INTERVAL)
            .build()
        jobScheduler.schedule(jobInfo)
    }
}