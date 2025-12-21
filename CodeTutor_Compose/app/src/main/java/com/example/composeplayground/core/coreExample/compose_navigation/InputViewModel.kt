package com.example.composeplayground.core.coreExample.compose_navigation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InputViewModel(
    private val savedStateHandle : SavedStateHandle
) : ViewModel() {

    companion object {
        private const val KEY_STATE = "ui_state"
    }

    private val _uiState = MutableStateFlow(savedStateHandle[KEY_STATE] ?: InputUIState())
    val uiState = _uiState.asStateFlow()


    private val _navEvents = MutableSharedFlow<NavEvent>()
    val navEvents : SharedFlow<NavEvent> = _navEvents.asSharedFlow()

    val concatenatedValue : String
        get() = uiState.value.text1 + uiState.value.text2

    fun onText1Changed(value : String) {
        updateSate { copy(text1 = value) }
    }

    fun onText2Changed(value : String) {
        updateSate { copy(text2 = value) }
    }

    fun onSubmitClicked() {
        viewModelScope.launch {
            _navEvents.emit(NavEvent.NavigateToResult)
        }
    }


    private fun updateSate(reducer : InputUIState.() -> InputUIState) {
        _uiState.update { current->
            current.reducer().also { newState ->
                savedStateHandle[KEY_STATE] = newState
            }
        }
    }


}