package com.example.smartHome.screen.device

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.smartHome.R
import com.example.smartHome.screen.device.widgets.DeviceCard

@Composable
fun DeviceScreen() {
    DeviceScreen(s = "")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
private fun DeviceScreen(s: String) {
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
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Устройства в ",
                    style = MaterialTheme.typography.titleMedium
                        .copy(color = MaterialTheme.colorScheme.background),
                    textAlign = TextAlign.Center,
                )
            }
        },
        content = {
            Column {
                Spacer(modifier = Modifier.weight(1f))
                FlowRow {
                    DeviceCard(
                        image = R.drawable.light_blue,
                        name = "Свет",
                        description = "70% яркость",
                        checked = true,
                        onCheckedChange = {}
                    )
                    DeviceCard(
                        image = R.drawable.light_blue,
                        name = "Свет",
                        description = "70% яркость",
                        checked = true,
                        onCheckedChange = {})
                    DeviceCard(
                        image = R.drawable.light_blue,
                        name = "Свет",
                        description = "70% яркость",
                        checked = true,
                        onCheckedChange = {})
                }
                Spacer(modifier = Modifier.weight(3f))
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.primary,

                shape = CircleShape
            ) {
                Icon(
                    Icons.Default.Add,
                    modifier = Modifier.size(70.dp),
                    contentDescription = "add",
                    tint = MaterialTheme.colorScheme.background,
                )
            }
        }
    )
}