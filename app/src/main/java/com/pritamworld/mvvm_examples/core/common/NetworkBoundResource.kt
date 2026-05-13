package com.pritamworld.mvvm_examples.core.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType> networkBoundResource(

    crossinline query: () -> Flow<ResultType>,

    crossinline fetch: suspend () -> RequestType,

    crossinline saveFetchResult: suspend (RequestType) -> Unit,

    crossinline shouldFetch: (ResultType) -> Boolean = { true }

): Flow<Result<ResultType>> = flow {

    // Loading state
    emit(Result.Loading)

    // Local DB data
    val localData = query().first()

    // Emit cached data first
    emit(Result.Success(localData))

    // Decide if API should be called
    if (shouldFetch(localData)) {

        try {

            // API call
            val remoteData = fetch()

            // Save into Room
            saveFetchResult(remoteData)

            // Emit updated Room data
            emitAll(
                query().map {
                    Result.Success(it)
                }
            )

        } catch (e: Exception) {

            emit(
                Result.Error(
                    message = e.message ?: "Network Error",
                    throwable = e
                )
            )
        }
    }
}