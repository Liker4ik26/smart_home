package com.example.smartHome.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.smartHome.R

    val Montserrat = FontFamily(
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_light, FontWeight.Light),
)

val Typography = Typography(

    titleLarge = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 19.2.sp,
        letterSpacing = 0.6.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 19.2.sp,
        letterSpacing = 0.6.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 36.sp,
        lineHeight = 14.4.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 19.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.4.sp,
        letterSpacing = 0.5.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 12.19.sp,
        letterSpacing = 0.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
)