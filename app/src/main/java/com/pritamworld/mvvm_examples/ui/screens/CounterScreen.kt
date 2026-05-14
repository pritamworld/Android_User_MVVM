package com.pritamworld.mvvm_examples.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pritamworld.mvvm_examples.domain.model.CounterViewModel

@Composable
fun CounterScreen(vm: CounterViewModel) {
    val count by vm.count.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Counter: $count")
        Button(onClick = { vm.increment() }) {
            Text("Increment")
        }
    }
}