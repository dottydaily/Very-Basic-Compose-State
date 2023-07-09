package com.example.verybasiccomposestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.verybasiccomposestate.examples.CarAnimation
import com.example.verybasiccomposestate.examples.CardViewExample
import com.example.verybasiccomposestate.examples.Counter
import com.example.verybasiccomposestate.examples.FourthExample
import com.example.verybasiccomposestate.examples.StateHoistingViewModelExample
import com.example.verybasiccomposestate.examples.ThirdExample
import com.example.verybasiccomposestate.ui.theme.VeryBasicComposeStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Counter() // Change with your wanted example here
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
    VeryBasicComposeStateTheme {
        Greeting("Android")
    }
}