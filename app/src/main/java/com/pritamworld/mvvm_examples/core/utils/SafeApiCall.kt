package com.pritamworld.mvvm_examples.core.utils

import retrofit2.HttpException
import java.io.IOException
import com.pritamworld.mvvm_examples.core.common.Result

suspend fun <T> safeApiCall(
    apiCall: suspend () -> T
): Result<T> {

    return try {

        Result.Success(apiCall())

    } catch (e: HttpException) {

        Result.Error(
            message = e.message ?: "HTTP Error",
            throwable = e
        )

    } catch (e: IOException) {

        Result.Error(
            message = "No Internet Connection",
            throwable = e
        )

    } catch (e: Exception) {

        Result.Error(
            message = e.localizedMessage ?: "Unknown Error",
            throwable = e
        )
    }
}