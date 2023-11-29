package com.example.smartHome.navigation

import android.content.Context
import androidx.navigation.NavController
import com.example.smartHome.screen.auth.AuthScreenNavigation
import com.example.smartHome.screen.signUp.RegistrationScreenNavigation
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.NavGraphSpec

class CommonNavGraphNavigator(
    private val context: Context,
    private val navGraph: NavGraphSpec,
    private val navController: NavController
) : RegistrationScreenNavigation,
AuthScreenNavigation{
//
//    override fun openNewsDetails(newsDetailsNavArg: NewsDetailsNavArg) {
//        navController.navigate(
//            NewsDetailsScreenDestination
//                (newsDetails = newsDetailsNavArg.asArticle()) within navGraph
//        )
//    }

    //    override fun navigationToHomeScreen() {
//        navController.navigate(NavGraphs.home) {
//            popUpTo(navController.graph.findStartDestination().id) { inclusive = true }
//        }
//    }
//
//    override fun navigateUp() {
//        navController.navigateUp()
//    }
//
//    override fun openNewsDetails(searchNewsNavArg: SearchNewsItemNavArg) {
//        navController.navigate(NewsDetailsScreenDestination(newsDetails = searchNewsNavArg.asArticle()) within navGraph)
//    }
//
//    override fun navigateToRegistrationScreen() {
//        navController.navigate(NavGraphs.registration)
//    }
//
//    override fun navigateToHomeScreen() {
//        navController.navigate(NavGraphs.home)
//    }
//
//    override fun onNavigateBack() {
//        navController.navigate(NavGraphs.authorization)
//    }
//
//    override fun onNavigateToProfileEdit() {
//        navController.navigate(NavGraphs.editProfile)
//    }
//
//    override fun navigateToProfile() {
//        navController.navigate(NavGraphs.profile)
//    }
//
//    override fun navigateBack() {
//        navController.navigateUp()
//    }

    override fun navigationToPinScreen() {
        navController.navigate(NavGraphs.signIn)
    }

    override fun navigateSignInScreen() {
        navController.navigate(NavGraphs.auth)
    }

    override fun navigationToSignInScreen() {
        navController.navigate(NavGraphs.signIn)
    }

    override fun navigateSignUpScreen() {
       navController.navigate(NavGraphs.signUp)
    }
}