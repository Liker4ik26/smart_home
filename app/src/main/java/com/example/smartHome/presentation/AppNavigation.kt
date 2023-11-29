package com.example.smartHome.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.smartHome.core.currentNavigator
import com.example.smartHome.navigation.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.ramcosta.composedestinations.spec.Route

@Composable
fun AppNavigation(
    navController: NavHostController,
    startRoute: Route,
    modifier: Modifier = Modifier
) {
    DestinationsNavHost(
        modifier = modifier,
        navGraph = NavGraphs.root,
        navController = navController,
        engine = rememberNavHostEngine(),
        startRoute = startRoute,
        dependenciesContainerBuilder = { dependency(currentNavigator(LocalContext.current)) }
    )
}