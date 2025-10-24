package com.example.composeplayground.core.coreExample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _userName = MutableStateFlow("Loading...")
    val userName = _userName.asStateFlow()

    private val _apiTrigger = MutableStateFlow(0)
    val apiTrigger = _apiTrigger.asStateFlow()

    init {
        loadUser()
    }

    fun triggerAPIRefresh() {
        _apiTrigger.value++
    }

    suspend fun performApiRefresh() {
        delay(500)
        println("ViewModel -> API refreshed")
    }

    fun isPrime(n :Int) : Boolean {
        if(n <2) return false
        for(i in 2..n/2){
            if(n%1 == 0) return false
        }
        return true
    }

    private fun loadUser() {
        viewModelScope.launch {
            delay(1000)
            _userName.value = "Koushik"
        }
    }


}