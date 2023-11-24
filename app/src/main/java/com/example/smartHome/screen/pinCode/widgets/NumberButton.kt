package com.example.smartHome.screen.pinCode.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NumberButton(
    modifier: Modifier = Modifier,
    number: String = "1",
    onClick: (number: String) -> Unit = {},
) {
    Button(
        onClick = {
            onClick(number)
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier
            .size(height = 80.dp, width = 110.dp)
            .padding(10.dp)
            .border(1.dp, color = MaterialTheme.colorScheme.secondary, RoundedCornerShape(5.dp)),
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(
            text = number,
            style = MaterialTheme.typography.displaySmall.copy(color = MaterialTheme.colorScheme.secondary)
        )
    }
}