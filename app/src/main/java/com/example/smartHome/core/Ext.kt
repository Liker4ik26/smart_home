package com.example.smartHome.core

import android.content.Context
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.example.smartHome.navigation.CommonNavGraphNavigator
import com.example.smartHome.navigation.NavGraphs
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.spec.NavGraphSpec

fun LazyListScope.pagingLoadStateItem(
    loadState: CombinedLoadStates,
    loadingContent: (@Composable LazyItemScope.() -> Unit),
    errorContent: (@Composable LazyItemScope.(String?) -> Unit),
) {
    when (loadState.append) {
        LoadState.Loading -> {
            item(key = "loadingFooter", content = loadingContent)
        }
        is LoadState.Error -> {
            val message = (loadState.append as LoadState.Error).error.localizedMessage
            item(key = "errorFooter", content = { errorContent(message) })
        }
        is LoadState.NotLoading -> {}
    }
    when (loadState.prepend) {
        LoadState.Loading -> {
            item(key = "loadingHeader", content = loadingContent)
        }
        is LoadState.Error -> {
            val message = (loadState.append as LoadState.Error).error.localizedMessage
            item(key = "errorHeader", content = { errorContent(message) })
        }
        is LoadState.NotLoading -> {}
    }
}

fun LazyGridScope.pagingLoadStateItem(
    loadState: CombinedLoadStates,
    loadingContent: (@Composable LazyGridItemScope.() -> Unit),
    errorContent: (@Composable LazyGridItemScope.(String?) -> Unit),
) {
    when (loadState.append) {
        LoadState.Loading -> {
            item(key = "loadingFooter", content = loadingContent)
        }
        is LoadState.Error -> {
            val message = (loadState.append as LoadState.Error).error.localizedMessage
            item(key = "errorFooter", content = { errorContent(message) })
        }
        is LoadState.NotLoading -> {}
    }
    when (loadState.prepend) {
        LoadState.Loading -> {
            item(key = "loadingHeader", content = loadingContent)
        }
        is LoadState.Error -> {
            val message = (loadState.append as LoadState.Error).error.localizedMessage
            item(key = "errorHeader", content = { errorContent(message) })
        }
        is LoadState.NotLoading -> {}
    }
}

@Stable
@Composable
fun NavController.currentBottomItemToState(): State<NavGraphSpec> {

    val selectedItem = remember { mutableStateOf(NavGraphs.root) }

    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            selectedItem.value = destination.navGraph()
        }
        addOnDestinationChangedListener(listener)

        onDispose { removeOnDestinationChangedListener(listener) }
    }
    return selectedItem
}

fun NavDestination.navGraph(): NavGraphSpec {
    hierarchy.forEach { destination ->
        NavGraphs.root.nestedNavGraphs.forEach { navGraph ->
            if (destination.route == navGraph.route) {
                return navGraph
            }
        }
    }
    throw RuntimeException("Unknown nav graph for destination $route")
}

fun DependenciesContainerBuilder<*>.currentNavigator(context: Context): CommonNavGraphNavigator {
    return CommonNavGraphNavigator(
        context,
        navBackStackEntry.destination.navGraph(),
        navController
    )
}