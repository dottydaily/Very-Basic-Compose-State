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
import kotlin.random.Random

@Composable
fun ThirdExample() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically,
        ),
    ) {
        var count by remember { mutableStateOf(0) }

        ResultNumbers(count = count)

        Button(onClick = { count++ }) {
            Text(
                text = "Increases count by 1",
                fontSize = 24.sp
            )
        }
    }
}

@Composable
private fun ResultNumbers(count: Int) {
    Column {
        val calculated = remember {
            getCalculated()
        }
        Text(
            text = "The calculated number is $calculated",
            fontSize = 32.sp
        )
        Text(
            text = "The count number is $count",
            fontSize = 32.sp
        )
    }
}

private fun getCalculated(): Int {
    var result = 0

    repeat(10_000_000) {
        result = Random.nextInt(0, 1000)
    }

    return result
}

@Preview
@Composable
private fun PreviewThirdExample() {
    ThirdExample()
}