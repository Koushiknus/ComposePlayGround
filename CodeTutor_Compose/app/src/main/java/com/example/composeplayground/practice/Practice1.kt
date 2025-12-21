package com.example.composeplayground.practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue

import com.example.composeplayground.core.coreExample.compose_navigation.InputViewModel
import java.nio.file.WatchEvent

@Composable
fun Practice(viewModel: InputViewModel) {

    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Screen A"
        )

        OutlinedTextField(
            value = uiState.text1,
            onValueChange = viewModel::onText1Changed,
            label = {Text("Text 1")},
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.text2,
            onValueChange = viewModel::onText2Changed,
            label = {Text("text 2 ")},
            modifier = Modifier.fillMaxWidth()
        )

    }


}