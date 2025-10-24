package com.example.composeplayground.core.coreExample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(viewModel: DashboardViewModel = viewModel()){

    val userName by viewModel.userName.collectAsState()

    val apiTrigger by viewModel.apiTrigger.collectAsState()

    //Do not survive screen rotation

    var count by remember { mutableIntStateOf(0) }

    /**
     * ------------------------------------------------------------
     * derivedStateOf:
     * Derived value that recomputes ONLY when 'count' changes.
     * Expensive calculations should go here.
     * ------------------------------------------------------------
     */
    val isCountEven by remember {
        derivedStateOf {
            println("Dervived Stateof recalculating")
            count%2 == 0
        }
    }

    //Survives screen rotation

    var message by rememberSaveable  { mutableStateOf("") }

    //Launched Effect runs only once
    LaunchedEffect(Unit) {
        println("Screen Launched -> API call already inside Viewmodel ")
    }

    /**
     * ------------------------------------------------------------
     * LaunchedEffect #2 (runs whenever a ViewModel state changes)
     * Calls a suspend function
     * ------------------------------------------------------------
     */
    LaunchedEffect(apiTrigger) {
        viewModel.performApiRefresh()
        println("LaunchedEffect(apiTrigger) -> Refresh triggered")
    }

    SideEffect {
        println("Sidefeect ->Count is $count")
    }

    // Scafflod Layout

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Dashboard") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {count++}
            ) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .padding(bottom  = 100.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "Welcome , $userName", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Count : $count")


            Button(onClick = {
                count++
            }) {
                Text("Increase count")
            }

            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Enter message") }
            )

            Spacer(modifier = Modifier.height(16.dp))



            Text("Your message: $message")

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.triggerAPIRefresh()
                }
            ) {
                Text("Refresh")
            }

    }
    }
}