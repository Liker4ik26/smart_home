package com.example.smartHome.screen.device.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DeviceCard(
    image: Int,
    name: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(
                1.dp, MaterialTheme.colorScheme.onSecondary, shape = RoundedCornerShape(28.dp)
            )
    ) {
        Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Image(
                painter = painterResource(id = image),
                modifier = Modifier.size(36.dp),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(44.dp))
            Switch(
                checked = checked,

                colors = SwitchDefaults
                    .colors(
                        checkedTrackColor = MaterialTheme.colorScheme.tertiary.copy(.5f),
                        uncheckedTrackColor = MaterialTheme.colorScheme.primary,
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        uncheckedThumbColor = MaterialTheme.colorScheme.onTertiary,
                        checkedBorderColor = Color.Transparent,
                        uncheckedBorderColor = Color.Transparent

                    ),
                onCheckedChange = { onCheckedChange(checked) })
        }
        Text(
            text = name,
            style = MaterialTheme.typography.titleSmall
                .copy(color = MaterialTheme.colorScheme.secondary),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = description,
            style = MaterialTheme.typography.titleSmall
                .copy(color = MaterialTheme.colorScheme.tertiary),
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, end = 16.dp)
        )
    }
}