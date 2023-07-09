package com.example.verybasiccomposestate.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun SecondCounter() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically,
        ),
    ) {
        var count by rememberSaveable {
            mutableStateOf(0)
        }
        var isShowing by rememberSaveable {
            mutableStateOf(true)
        }

        if (isShowing) {
            Column {
                val randomNumber = remember {
                    mutableStateOf(Random.nextInt(1, 1000))
                }
                Text(
                    text = "The current count is $count",
                    fontSize = 32.sp
                )
                Text(
                    text = "The random number is ${randomNumber.value}",
                    fontSize = 32.sp
                )
            }
        }

        Button(onClick = { count++ }) {
            Text(
                text = "Increases count by 1",
                fontSize = 24.sp
            )
        }

        Button(onClick = { isShowing = !isShowing }) {
            Text(
                text = "Show/Hide text",
                fontSize = 24.sp
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCounter() {
    SecondCounter()
}