package com.pritamworld.mvvm_examples.sync

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.pritamworld.mvvm_examples.worker.PostSyncWorker
import java.util.concurrent.TimeUnit

object SyncScheduler {

    fun startPostSync(context: Context) {
        Log.d("startPostSync", "STARTED")

        val syncRequest =
            PeriodicWorkRequestBuilder<PostSyncWorker>(
                15,
                TimeUnit.MINUTES
            )
                .setConstraints(
                    Constraints.Builder()
                        .setRequiredNetworkType(
                            NetworkType.CONNECTED
                        )
                        .build()
                )
                .build()

        WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork(
                "post_sync",
                ExistingPeriodicWorkPolicy.KEEP,
                syncRequest
            )
    }

    /*
    One-Time Manual Sync. Useful for pull-to-refresh.
     */
    fun syncNow(context: Context) {

        val request =
            OneTimeWorkRequestBuilder<PostSyncWorker>()
                .build()

        WorkManager.getInstance(context)
            .enqueue(request)
    }
}