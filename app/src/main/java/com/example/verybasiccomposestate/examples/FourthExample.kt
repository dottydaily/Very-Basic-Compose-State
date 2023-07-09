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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FourthExample() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.CenterVertically,
        )
    ) {
        var count by remember {
            mutableStateOf(0)
        }
        var anotherCount by remember {
            mutableStateOf(0)
        }

        StatelessCounter(value = count, onValueChange = { count++ })
        StatelessCounter(value = anotherCount, onValueChange = { anotherCount++ })
    }
}

@Composable
private fun StatelessCounter(value: Int, onValueChange: () -> Unit) {
    Column {
        Text(
            text = "Value is $value",
            fontSize = 24.sp
        )
        Button(onClick = onValueChange) {
            Text(
                "Increases value",
                fontSize = 16.sp,
            )
        }
    }
}

@Preview
@Composable
fun PreviewFourthExample() {
    FourthExample()
}