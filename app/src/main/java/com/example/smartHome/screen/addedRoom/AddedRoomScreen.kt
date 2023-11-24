package com.example.smartHome.screen.addedRoom

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.smartHome.R
import com.example.smartHome.screen.addedRoom.widgets.RoomImageButton

@Composable
fun AddedRoomScreen() {
    AddedRoomScreen(s = "")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
private fun AddedRoomScreen(s: String) {
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
                    text = stringResource(R.string.added_room),
                    style = MaterialTheme.typography.titleMedium
                        .copy(color = MaterialTheme.colorScheme.background),
                    textAlign = TextAlign.Center,
                )
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Spacer(modifier = Modifier.weight(2f))
                TextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(
                            text = stringResource(R.string.room_name),
                            style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(7.dp)
                        ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.primary
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(R.string.selected_room),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleSmall
                        .copy(color = MaterialTheme.colorScheme.tertiary),
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    RoomImageButton(
                        onClick = { /*TODO*/ },
                        image = R.drawable.living_white,
                        text = stringResource(R.string.living),
                        isSelected = false
                    )
                    RoomImageButton(
                        onClick = { /*TODO*/ },
                        image = R.drawable.kitchen_white,
                        text = stringResource(R.string.kitchen),
                        isSelected = true
                    )
                    RoomImageButton(
                        onClick = { /*TODO*/ },
                        image = R.drawable.bathroom_white,
                        text = stringResource(R.string.bathroom),
                        isSelected = false
                    )
                    RoomImageButton(
                        onClick = { /*TODO*/ },
                        image = R.drawable.office_white,
                        text = stringResource(R.string.office),
                        isSelected = false
                    )
                    RoomImageButton(
                        onClick = { /*TODO*/ },
                        image = R.drawable.bed_white,
                        text = stringResource(R.string.bed),
                        isSelected = false
                    )
                    RoomImageButton(
                        onClick = { /*TODO*/ },
                        image = R.drawable.tv_white,
                        text = stringResource(R.string.tv),
                        isSelected = false
                    )
                }

                Spacer(modifier = Modifier.weight(2f))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(20),
                        colors = ButtonDefaults.buttonColors(
                            containerColor =
                            MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier
                            .height(50.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.save),
                            style = MaterialTheme.typography.titleMedium
                                .copy(color = MaterialTheme.colorScheme.background)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(0.4f))
            }
        }
    )
}