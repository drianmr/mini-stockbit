package com.drianmr.stockbit.mini.ext

import com.drianmr.stockbit.mini.data.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Call specified [call] network request and wrap it with flow builder
 * and wrap [T] with [Result] for exposing network status.
 *
 * At first, this flow will emit [Result.Loading] immediately, then
 * emit [Result.Success] if given [call] is success.
 * Any exception thrown in [call] will emit [Result.Error].
 *
 * @param T Network response type
 * @param call Function for calling network request
 */
@Suppress("RemoveExplicitTypeArguments")
inline fun <T> fetchFromNetwork(crossinline call: suspend () -> T): Flow<Result<T>> {
    return flow {
        emit(Result.loading<T>())

        try {
            val response = call()

            emit(Result.success(response))
        } catch (e: Exception) {
            emit(Result.error<T>(e))
        }
    }
}
