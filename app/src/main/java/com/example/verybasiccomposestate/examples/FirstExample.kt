package com.example.verybasiccomposestate.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter() {
    var count = 0

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically,
        ),
    ) {
        Text(
            text = "The current count is $count",
            fontSize = 32.sp
        )
        Button(onClick = { count++ }) {
            Text(
                text = "Increases count by 1",
                fontSize = 24.sp
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCounter() {
    Counter()
}