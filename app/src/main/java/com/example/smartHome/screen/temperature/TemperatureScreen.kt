package com.example.smartHome.screen.temperature

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.smartHome.R

@Composable
fun TemperatureScreen() {
    TemperatureScreen(s = "")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TemperatureScreen(s: String) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .padding(top = 50.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(50.dp)
                ) {
                    Icon(
                        Icons.Default.KeyboardArrowLeft,
                        modifier = Modifier.size(48.dp),
                        contentDescription = "arrowLeft",
                        tint = MaterialTheme.colorScheme.background,
                    )
                }
                Spacer(modifier = Modifier.weight(2f))
                Text(
                    text = stringResource(R.string.thermo),
                    style = MaterialTheme.typography.titleMedium
                        .copy(color = MaterialTheme.colorScheme.background),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.weight(2.6f))
            }
        },
        content = {
            Column {
                Spacer(modifier = Modifier.weight(1f))
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.onSecondary,
                            shape = RoundedCornerShape(28.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        Image(
                            painter = painterResource(id = R.drawable.thermo_blue),
                            modifier = Modifier.size(70.dp),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            text = stringResource(id = R.string.thermo),
                            style = MaterialTheme.typography.titleMedium
                                .copy(color = MaterialTheme.colorScheme.secondary),
                            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Switch(
                            checked = false,
                            colors = SwitchDefaults
                                .colors(
                                    checkedTrackColor = MaterialTheme.colorScheme.tertiary.copy(.5f),
                                    uncheckedTrackColor = MaterialTheme.colorScheme.primary,
                                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                                    uncheckedThumbColor = MaterialTheme.colorScheme.onTertiary,
                                    checkedBorderColor = Color.Transparent,
                                    uncheckedBorderColor = Color.Transparent

                                ),
                            onCheckedChange = {},
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                    Text(
                        text = "27°C градусов",
                        style = MaterialTheme.typography.titleSmall
                            .copy(color = MaterialTheme.colorScheme.tertiary),
                        modifier = Modifier.padding(start = 18.dp, end = 16.dp)
                    )
                    Slider(
                        value = .5f,
                        onValueChange = {},
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 18.dp, end = 18.dp, bottom = 18.dp)
                    ) {
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                        Text(
                            text = "5",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                        Text(
                            text = "10",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                        Text(
                            text = "15",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                        Text(
                            text = "20",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                        Text(
                            text = "25",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                        Text(
                            text = "30",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                        Text(
                            text = "35",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(4f))
            }
        },
    )
}