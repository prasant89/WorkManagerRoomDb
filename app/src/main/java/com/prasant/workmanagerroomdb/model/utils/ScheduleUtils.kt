package com.prasant.workmanagerroomdb.model.utils

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.prasant.workmanagerroomdb.model.services.MyJobScheduler

class ScheduleUtils {
    // schedule the start of the service every 10 - 30 seconds
    @RequiresApi(Build.VERSION_CODES.M)
     fun scheduleJob(context: Context){
       val serviceComponent:ComponentName = ComponentName(context,MyJobScheduler::class.java)
        var builder:JobInfo.Builder = JobInfo.Builder(0,serviceComponent)
        builder.setMinimumLatency(1*1000)
        builder.setOverrideDeadline(3*1000)
        //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED); // require unmetered network
        //builder.setRequiresDeviceIdle(true); // device should be idle
        //builder.setRequiresCharging(false); // we don't care if the device is charging or not
        var  jobScheduler :JobScheduler= context.getSystemService(JobScheduler::class.java)
        jobScheduler.schedule(builder.build());

    }
}