package com.example.smartHome.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = MediumElectricBlue,
    secondary = Color.Black,
    tertiary = MountainMist,
    background = Color.White,
    surface = MediumTurquoise,
    onPrimary = EbonyClay,
    onSecondary = TiffanyBlue,
    error = FerrariRed,
    onTertiary = Color.White,
    onSurface = CopperRust,
)

private val lightColorScheme = lightColorScheme(
    primary = MediumElectricBlue,
    secondary = Color.Black,
    tertiary = MountainMist,
    background = Color.White,
    surface = MediumTurquoise,
    onPrimary = EbonyClay,
    onSecondary = TiffanyBlue,
    error = FerrariRed,
    onTertiary = Color.White,
    onSurface = CopperRust,
)

@Composable
fun SmartHomeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    (view.context as? Activity)?.window
        ?: throw Exception("Not in an activity - unable to get Window reference")
    val colorScheme = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = Color.Transparent.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}