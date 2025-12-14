package com.example.composeplayground.kotlin_playground

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope


/**
 * Sealed class Example
 */
sealed class ApiResult<out T> {
    data class Success<T>(val data : T) : ApiResult<T>()
    data class Error(val message : String, val throwable : Throwable? = null) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}

suspend fun runParallel() : Pair<Any,Any> = coroutineScope {
    val firstcall = async { callAPI1() }
    val secondCall = async { callAPI2() }
    firstcall.await() to secondCall.await()
}

suspend fun callAPI1() {
}

suspend fun callAPI2() {
}