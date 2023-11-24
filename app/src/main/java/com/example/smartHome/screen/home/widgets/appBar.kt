package com.example.smartHome.screen.home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.smartHome.R

@Composable
fun HomeAppBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(end = 18.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = stringResource(R.string.your_home),
                style = MaterialTheme.typography.titleMedium
                    .copy(color = MaterialTheme.colorScheme.background),
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(
                    top = 50.dp,
                    bottom = 10.dp,
                    start = 18.dp,
                    end = 18.dp
                )
            )
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = "location",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(start = 18.dp)
                )
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = "г. Омск, ул. Ленина, д. 24",
                    style = MaterialTheme.typography.titleSmall
                        .copy(color = MaterialTheme.colorScheme.tertiary),
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(R.string.rooms),
                style = MaterialTheme.typography.titleMedium
                    .copy(color = MaterialTheme.colorScheme.background),
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = 10.dp, start = 18.dp, end = 18.dp)
            )
            Spacer(
                modifier = Modifier
                    .height(6.dp)
                    .width(150.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(top = 16.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(50.dp)
        ) {
            Icon(
                Icons.Default.Settings,
                modifier = Modifier.size(48.dp),
                contentDescription = "location",
                tint = MaterialTheme.colorScheme.background,
            )
        }
    }
}