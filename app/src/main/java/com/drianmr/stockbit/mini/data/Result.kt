package com.drianmr.stockbit.mini.data

private typealias ResultLoading<T> = (data: T?) -> Unit
private typealias ResultSuccess<T> = (data: T) -> Unit
private typealias ResultError<T> = (data: T?, throwable: Throwable) -> Unit

/**
 * A generic sealed class that holds a value with its status.
 */
sealed class Result<T> {

    data class Loading<T>(val data: T?) : Result<T>()

    data class Success<T>(val data: T) : Result<T>()

    data class Error<T>(val data: T?, val throwable: Throwable) : Result<T>()

    companion object {

        fun <T> loading(data: T? = null): Result<T> = Loading(data)

        fun <T> success(data: T): Result<T> = Success(data)

        fun <T> error(throwable: Throwable, data: T? = null): Result<T> = Error(data, throwable)
    }
}

/**
 * Invoke given [action] if this Result is [Result.Loading]
 */
inline fun <T> Result<T>.onLoading(action: ResultLoading<T>) {
    if (this is Result.Loading) {
        action(data)
    }
}

/**
 * Invoke given [action] if this Result is [Result.Success]
 */
inline fun <T> Result<T>.onSuccess(action: ResultSuccess<T>) {
    if (this is Result.Success) {
        action(data)
    }
}

/**
 * Invoke given [action] if this Result is [Result.Error]
 */
inline fun <T> Result<T>.onError(action: ResultError<T>) {
    if (this is Result.Error) {
        action(data, throwable)
    }
}
