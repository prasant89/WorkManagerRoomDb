package com.prasant.workmanagerroomdb.model.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.Arrays
import java.util.Random

class LocalWordService : Service() {
    private val mBinder: IBinder = MyBinder()
    private val resultList: MutableList<String> = ArrayList()
    private var counter = 1


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        addResultValues()
        return START_NOT_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        addResultValues()
        return mBinder
    }

    inner class MyBinder : Binder() {
        fun getService(): LocalWordService {
            return this@LocalWordService
        }
    }

    fun getWordList(): List<String?>? {
        return resultList
    }

    private fun addResultValues() {
        val random = Random()
        val input: List<String> = Arrays.asList("Linux", "Android", "iPhone", "Windows7")
        resultList.add(input[random.nextInt(3)] + " " + counter++)
        if (counter == Int.MAX_VALUE) {
            counter = 0
        }
    }
}