package com.example.smartHome.navigation

import com.example.smartHome.screen.destinations.AuthScreenDestination
import com.example.smartHome.screen.destinations.PinCodeScreenDestination
import com.example.smartHome.screen.destinations.SignInScreenDestination
import com.example.smartHome.screen.destinations.SignUpScreenDestination
import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object NavGraphs {
    val signUp = object : NavGraphSpec {
        override val route = "signUp"
        override val startRoute = SignUpScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            SignUpScreenDestination,
        ).routedIn(this).associateBy { it.route }
    }
    val pinCode = object : NavGraphSpec {
        override val route = "pinCode"
        override val startRoute = PinCodeScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            PinCodeScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val signIn = object : NavGraphSpec {
        override val route = "signIn"
        override val startRoute = SignInScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            SignInScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val auth = object : NavGraphSpec {
        override val route = "auth"
        override val startRoute = AuthScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            AuthScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route = "root"
        override val startRoute = signUp
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
        override val nestedNavGraphs = listOf(signUp, pinCode, signIn, auth)
    }
}