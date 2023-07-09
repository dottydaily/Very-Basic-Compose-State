package com.example.verybasiccomposestate.examples

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.verybasiccomposestate.R

@Composable
fun CarAnimation() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.CenterVertically,
        )
    ) {
        var isCarShowing by remember { mutableStateOf(false) }

        OrdinaryCar(isShowing = isCarShowing)

        Button(onClick = { isCarShowing = !isCarShowing } ) {
            Text(text = "Show/Hide car")
        }
    }
}

@Composable
private fun OrdinaryCar(isShowing: Boolean) {
    val alpha by animateFloatAsState(
        targetValue = if (isShowing) 1f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )

    Image(
        modifier = Modifier
            .size(200.dp)
            .alpha(alpha),
        painter = painterResource(id = R.drawable.img_sport_car),
        contentDescription = "Ordinary car"
    )
}

@Composable
private fun BollywoodCar(isShowing: Boolean) {
    val alpha by animateFloatAsState(
        targetValue = if (isShowing) 1f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )

    val oneRoundDegree = 360
    val repeatCount = 4

    Image(
        modifier = Modifier
            .size(200.dp)
            .alpha(alpha)
            .rotate((oneRoundDegree * repeatCount) * alpha),
        painter = painterResource(id = R.drawable.img_sport_car),
        contentDescription = "Bollywood car"
    )
}

@Preview
@Composable
private fun PreviewCarAnimation() {
    CarAnimation()
}