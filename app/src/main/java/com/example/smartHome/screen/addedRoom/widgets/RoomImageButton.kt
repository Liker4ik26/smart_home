package com.example.smartHome.screen.addedRoom.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RoomImageButton(
    onClick: () -> Unit,
    image: Int,
    text: String,
    isSelected: Boolean
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (isSelected) {
            Button(
                onClick = { onClick() }, colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Image(
                    painter = painterResource(id = image),
                    modifier = Modifier.size(height = 90.dp, width = 60.dp),
                    contentDescription = null
                )
            }
        } else {
            Button(
                onClick = { onClick() }, colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Image(
                    painter = painterResource(id = image),
                    modifier = Modifier.size(height = 90.dp, width = 60.dp),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))
        if (isSelected) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall
                    .copy(color = MaterialTheme.colorScheme.primary)
            )
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall
                    .copy(color = MaterialTheme.colorScheme.tertiary)
            )
        }
    }
}
