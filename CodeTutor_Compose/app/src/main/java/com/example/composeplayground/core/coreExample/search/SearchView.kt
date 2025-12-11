package com.example.composeplayground.core.coreExample.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun UserListScreen(viewModel: SearchViewModel) {
    val searchQuery = viewModel.searchQuery
    val users = viewModel.filteredUsers
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
            // Search Bar
        TextField(
            value = searchQuery,
            onValueChange = {  viewModel.onSearchQuery(it)},
            label = { Text("Search names")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            items(users){
               UserItem(it)
                Divider()
            }
        }
          // Space

        //Load the list View
    }
}

@Composable
fun UserItem(user: User) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Text("Username :  ${user.name}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}