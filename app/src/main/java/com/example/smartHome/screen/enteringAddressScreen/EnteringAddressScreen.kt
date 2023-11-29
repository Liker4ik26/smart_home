package com.example.smartHome.screen.enteringAddressScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.smartHome.R
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun EnteringAddressScreen() {
    EnteringAddressScreen(s = "")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EnteringAddressScreen(s: String) {

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.added_address),
                style = MaterialTheme.typography.titleMedium
                    .copy(color = MaterialTheme.colorScheme.background),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 50.dp, bottom = 20.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(R.string.added_your_address),
            style = MaterialTheme.typography.titleSmall
                .copy(color = MaterialTheme.colorScheme.secondary),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = {
                Text(
                    text = stringResource(R.string.address),
                    style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.tertiary)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
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
        Spacer(modifier = Modifier.weight(2f))
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
        Spacer(modifier = Modifier.weight(0.4f))

    }
}