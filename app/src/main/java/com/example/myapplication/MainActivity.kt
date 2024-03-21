package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Jose")
                    Clock()

                }
            }
        }
    }
}

fun soma() : Int {
    return 1 + 1
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!\n",
        modifier = modifier
    )
}

@Composable
fun Clock() {
    var currentTime by remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        while (true) {
            val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val currentTimeString = dateFormat.format(Date())
            currentTime = currentTimeString
            delay(1000)
        }
    }

    Text(
        text = "Current Time: $currentTime",
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
