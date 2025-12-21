package com.example.composeplayground.kotlin_playground

import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

//“You have a callback-based API. Convert it to a suspend function.”

suspend fun fetchData() = suspendCancellableCoroutine { continuation ->

    continuation.resume("")
    continuation.invokeOnCancellation {

    }

}

//Reducer pattern
data class UiState(
    val isLoading : Boolean = false ,
    val data : List<String> = emptyList<String>(),
    val error : String? = null
)

sealed class Action() {
    object Load : Action()
    data class Success(val data : List<String>) : Action()
    data class Error(val message : String) : Action()
}

fun reduce(state: UiState,action: Action) : UiState =
    when(action){
        is Action.Load -> {
            state.copy(isLoading = true)
        }
        is Action.Success -> {
            state.copy(
                isLoading = false,
                data = action.data
            )
        }
        is Action.Error -> {
            state.copy(
                isLoading = false,
                error = action.message
            )
        }
    }