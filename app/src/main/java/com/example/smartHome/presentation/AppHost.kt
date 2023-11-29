package com.example.smartHome.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.smartHome.navigation.NavGraphs


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHost() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(), content = {
        AppNavigation(
            navController = navController,
            startRoute = NavGraphs.auth,
            modifier = Modifier,
        )
    })
}