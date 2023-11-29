package com.example.smartHome.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smartHome.R
import com.example.smartHome.screen.home.widgets.HomeAppBar
import com.example.smartHome.screen.home.widgets.RoomCard
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun HomeScreen() {
    HomeScreen(s = "")
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun HomeScreen(s: String) {
    Scaffold(
        topBar = { HomeAppBar() },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(48.dp))
                    RoomCard(image = R.drawable.living_white, roomName = "Гостиная")
                    RoomCard(image = R.drawable.living_white, roomName = "Гостиная")
                    RoomCard(image = R.drawable.living_white, roomName = "Гостиная")
                    RoomCard(image = R.drawable.living_white, roomName = "Гостиная")
                    RoomCard(image = R.drawable.living_white, roomName = "Гостиная")
                    RoomCard(image = R.drawable.living_white, roomName = "Гостиная")
                    RoomCard(image = R.drawable.living_white, roomName = "Гостиная")
                    RoomCard(image = R.drawable.living_white, roomName = "Гостиная")

                }
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