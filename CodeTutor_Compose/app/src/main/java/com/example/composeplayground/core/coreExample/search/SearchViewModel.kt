package com.example.composeplayground.core.coreExample.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    private val  _users = listOf<User>(
        User("1","Koushik"),
        User(id = "2", name = "Jaya")
    )


    var searchQuery by mutableStateOf("")
        private set

    val filteredUsers : List<User>
        get() = if(searchQuery.isEmpty()) _users
                else _users.filter { it.name.contains(searchQuery,ignoreCase = true) }

    fun onSearchQuery(query : String) {
        searchQuery = query
    }
}

data class User(
    val id : String,
    val name : String
)