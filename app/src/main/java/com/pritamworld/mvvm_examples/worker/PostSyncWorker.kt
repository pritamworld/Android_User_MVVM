package com.pritamworld.mvvm_examples.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.pritamworld.mvvm_examples.domain.repository.PostRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class PostSyncWorker @AssistedInject constructor(

    @Assisted private val context: Context,

    @Assisted params: WorkerParameters,

    private val repository: PostRepository

) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {

        return try {

            // Trigger sync
            repository.syncPosts()

            Result.success()

        } catch (e: Exception) {

            Result.retry()
        }
    }
}