package com.example.smartHome.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.smartHome.R
import com.example.smartHome.screen.signUp.SingUpUiEvent
import com.example.smartHome.ui.theme.MediumTurquoise
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun AuthScreen(navigation: AuthScreenNavigation) {
    AuthScreen(
        viewModel = hiltViewModel(),
        onNavigateToSignInScreen = navigation::navigationToSignInScreen,
        onNavigateToSignUpScreen = navigation::navigateSignUpScreen
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AuthScreen(
    viewModel: AuthViewModel,
    onNavigateToSignInScreen: () -> Unit,
    onNavigateToSignUpScreen: () -> Unit,
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is AuthUiEffect.NavigateToSignInScreen -> onNavigateToSignInScreen()
                is AuthUiEffect.NavigateToSignUpScreen -> onNavigateToSignUpScreen()
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_image),
            contentDescription = "Background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.drawWithCache {
                val gradient = Brush.linearGradient(
                    colors = listOf(
                        MediumTurquoise,
                        MediumTurquoise.copy(alpha = .23f),
                    ),
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.SrcOver)
                }
            }
        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(4.0f))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier.size(width = 80.dp, height = 100.dp)
            )
            Text(
                text = stringResource(R.string.smart_home),
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.background)
            )
            Spacer(modifier = Modifier.weight(.2f))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.7f)
                ),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, top = 20.dp, bottom = 30.dp, end = 24.dp)

            ) {
                Text(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 10.dp),
                    text = stringResource(R.string.email),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.tertiary)
                )
                TextField(
                    value = state.email,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        cursorColor = Color.Black,
                        disabledIndicatorColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Black
                    ),
                    onValueChange = {viewModel.sendEvent(AuthUiEvent.OnTypeEmail(it)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 16.dp, vertical = 0.dp),
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 10.dp),
                    text = stringResource(R.string.password),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.tertiary)
                )
                TextField(
                    value = state.password,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        cursorColor = Color.Black,
                        disabledIndicatorColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Black
                    ),
                    onValueChange = { viewModel.sendEvent(AuthUiEvent.OnTypePassword(it))},
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(start = 16.dp, end = 16.dp, bottom = 20.dp),
                )
            }
            Spacer(modifier = Modifier.weight(2.0f))
            Button(
                onClick = {
                    viewModel.sendEvent(AuthUiEvent.OnSignIn)
                },
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 54.dp)
            ) {
                Text(
                    text = stringResource(R.string.sign_in),
                    style = MaterialTheme.typography.titleMedium
                        .copy(color = MaterialTheme.colorScheme.background)
                )
            }
            Spacer(modifier = Modifier.height(28.dp))
            Button(
                onClick = {
                    viewModel.sendEvent(AuthUiEvent.OnSingUp)
                },
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 54.dp)
            ) {
                Text(
                    text = stringResource(R.string.sign_up),
                    style = MaterialTheme.typography.titleMedium
                        .copy(color = MaterialTheme.colorScheme.background)
                )
            }
            Spacer(modifier = Modifier.weight(2.0f))
        }
    }
}