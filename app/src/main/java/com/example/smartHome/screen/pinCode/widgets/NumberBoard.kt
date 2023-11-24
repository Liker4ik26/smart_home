package com.example.smartHome.screen.pinCode.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NumberBoard(
    onNumberClick: (num: String) -> Unit,
) {
    val buttons = (1..9).toList()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        buttons.chunked(3).forEach { buttonRow ->
            Row(
            ) {
                buttonRow.forEach { buttonNumber ->

                    NumberButton(
                        number = buttonNumber.toString(),
                        onClick = onNumberClick,
                        modifier = Modifier
                            .weight(1f)
                    )

                }
            }
        }
    }
}