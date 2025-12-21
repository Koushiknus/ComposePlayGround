package com.example.composeplayground.core.coreExample.compose_navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputScreen(viewModel: InputViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
           verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        //Text

        Text(text = "Screen A ", style = MaterialTheme.typography.titleLarge)


        // Text Field

        OutlinedTextField(
            value = uiState.text1,
            onValueChange = viewModel::onText1Changed,
            label = {Text("First Value")},
            modifier = Modifier.fillMaxWidth()
        )

        //Text Field

        OutlinedTextField(
            value = uiState.text2,
            onValueChange = viewModel::onText2Changed,
            label = {Text("Second value")},
            modifier = Modifier.fillMaxWidth()
        )

        //Button

        Button(
            onClick = viewModel::onSubmitClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }

}