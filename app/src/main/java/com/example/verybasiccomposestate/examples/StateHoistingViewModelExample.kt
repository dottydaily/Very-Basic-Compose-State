package com.example.verybasiccomposestate.examples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StateHoistingViewModelExample(
    // Require dependency -> androidx.lifecycle:lifecycle-viewmodel-compose:latestVersion
    viewModel: StateHoistingViewModel = viewModel()
) {
    val count by viewModel.count

    // Require dependency -> androidx.compose.runtime:runtime-livedata:latestVersion
    val anotherCount by viewModel.anotherCount.observeAsState(0)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        CounterCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            count = count,
            onIncreasingCount = viewModel::increaseCount,
            onDecreasingCount = viewModel::decreaseCount,
        )

        CounterCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            count = anotherCount,
            onIncreasingCount = viewModel::increaseAnotherCount,
            onDecreasingCount = viewModel::decreaseAnotherCount,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CounterCard(
    count: Int,
    onIncreasingCount: () -> Unit,
    onDecreasingCount: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .then(modifier)
            .animateContentSize(),
        shape = RoundedCornerShape(48.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        onClick = { isExpanded = !isExpanded }
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
        ) {
            Text(
                text = "The current count is $count",
                fontSize = 24.sp,
            )

            AnimatedVisibility(visible = isExpanded) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 8.dp,
                        alignment = Alignment.End,
                    )
                ) {
                    IconButton(onClick = onDecreasingCount) {
                        Icon(
                            imageVector = Icons.Filled.Remove,
                            contentDescription = "Decrease button",
                        )
                    }
                    IconButton(onClick = onIncreasingCount) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Increase button",
                        )
                    }
                }
            }
        }
    }
}