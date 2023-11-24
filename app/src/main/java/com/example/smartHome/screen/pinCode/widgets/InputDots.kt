package com.example.smartHome.screen.pinCode.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InputDots(
    numbers: List<Int> = listOf(1, 2),
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        for (i in 0..3) {
            PinIndicator(
                filled = when (i) {
                    0 -> numbers.isNotEmpty()
                    else -> numbers.size > i
                }
            )
        }

    }
}

@Composable
private fun PinIndicator(
    filled: Boolean,
) {
    Box(
        modifier = Modifier
            .padding(15.dp)
            .size(20.dp)
            .clip(CircleShape)
            .background(if (filled) MaterialTheme.colorScheme.background
            else Color(0xFFD9D9D9)
            )
    )
}