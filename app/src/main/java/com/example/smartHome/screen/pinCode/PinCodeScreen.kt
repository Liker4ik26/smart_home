package com.example.smartHome.screen.pinCode

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.smartHome.R
import com.example.smartHome.screen.pinCode.widgets.InputDots
import com.example.smartHome.screen.pinCode.widgets.NumberBoard
import com.example.smartHome.ui.theme.MediumTurquoise
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun PinCodeScreen() {
    PinCodeScreen(s = "")
}


@Composable
private fun PinCodeScreen(s: String) {
    val pin = remember {
        mutableStateListOf<Int>(
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_image),
            contentDescription = "Background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.drawWithCache {
                val gradient = Brush.linearGradient(
                    colors = listOf(
                        MediumTurquoise,
                        MediumTurquoise.copy(alpha = .23f),
                    ),
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.SrcOver)
                }
            }
        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1.0f))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier.size(width = 80.dp, height = 100.dp)
            )
            Text(
                text = stringResource(R.string.create_pin_code),
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.background)
            )
            Spacer(modifier = Modifier.weight(.2f))
            InputDots(pin)
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.7f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, top = 20.dp, bottom = 30.dp, end = 24.dp)
            ) {
                NumberBoard(
                    onNumberClick = { mynumber ->
                        if (pin.size < 4)
                            pin.add(mynumber.toInt())
                    }
                )
            }
            Spacer(modifier = Modifier.weight(2.0f))
        }
    }
}