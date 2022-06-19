package com.example.assignment.ui.workManager

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import java.util.concurrent.TimeUnit

class WorkManagerViewModel(application: Application) : ViewModel() {
    private val workManager = WorkManager.getInstance(application)
    /**
     * Start WorkManager
     * */
    fun startWorker() {
        val data = Data.Builder()
            .putString("KEY", "Sending Work data here")
            .build()
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        /**
         * Periodic Work Request
         * */
        val request = PeriodicWorkRequestBuilder<MyWorker>(5000,TimeUnit.MICROSECONDS)
            .setInputData(data)
            .setConstraints(constraints)
            .build()
        /**
         * One Time Work Request
         * */
      /*  val request = OneTimeWorkRequestBuilder<MyWorker>()
            .setInputData(data)
            .setConstraints(constraints)
            .build()*/
        workManager.enqueue(request)
    }
    /**
     * Cancel WorkManager
     * */
    fun cancelWorker(){
        workManager.cancelAllWork()
    }
    /**
     * WorkManagerViewModelFactory factory
     * */
    @Suppress("UNCHECKED_CAST")
    class WorkManagerViewModelFactory(private var application: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(WorkManagerViewModel::class.java)) {
                WorkManagerViewModel(application) as T
            } else {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}