package com.example.assignment.ui.workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(cxt:Context , params: WorkerParameters) : Worker(cxt,params) {
    override fun doWork(): Result {
        val data = inputData.getString("KEY")
        Log.d("asdasdasdasd",data.toString())
        return Result.success()
    }
}