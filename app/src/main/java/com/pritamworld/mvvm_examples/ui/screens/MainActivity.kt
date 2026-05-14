package com.pritamworld.mvvm_examples.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.pritamworld.mvvm_examples.domain.model.CounterViewModel
import com.pritamworld.mvvm_examples.sync.SyncScheduler
import com.pritamworld.mvvm_examples.ui.theme.MVVM_ExamplesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        enableEdgeToEdge()

        SyncScheduler.startPostSync(this)

        setContent {
            MVVM_ExamplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "World",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                  //  CounterScreen(viewModel)
                   // UserScreen()
                    PostScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVM_ExamplesTheme {
        Greeting("World")
    }
}