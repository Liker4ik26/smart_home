package com.example.smartHome.screen.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RoomCard(image: Int, roomName: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(2.dp, MaterialTheme.colorScheme.primary,
                RoundedCornerShape(20.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(24.dp)
        ) {
            Image(painter = painterResource(id = image), contentDescription = null)
            Spacer(modifier = Modifier.weight(0.2f))
            Text(
                text = roomName,
                style = MaterialTheme.typography.titleMedium
                    .copy(color = MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.weight(0.2f))
        }
    }
}