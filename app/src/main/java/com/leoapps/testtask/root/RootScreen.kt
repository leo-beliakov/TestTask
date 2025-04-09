package com.leoapps.testtask.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.leoapps.testtask.detail.DetailScreen
import com.leoapps.testtask.detail.DetailViewModel
import com.leoapps.testtask.main.presentation.RestaurantScreen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Serializable
object RestaurantDestination

@Serializable
data class MenuItemDestination(
    val menuItemId: Int
)


@Composable
fun RootScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RestaurantDestination,
        modifier = modifier
    ) {
        composable<RestaurantDestination> {
            RestaurantScreen(
                onItemClick = { menuItemId ->
                    navController.navigate(MenuItemDestination(menuItemId))
                }
            )
        }

        dialog<MenuItemDestination> { backStackEntry ->
            val menuItemId = backStackEntry.toRoute<MenuItemDestination>().menuItemId
            DetailScreen(
                onDismiss = { navController.navigateUp() },
                viewModel = koinViewModel<DetailViewModel>(
                    parameters = { parametersOf(menuItemId) }
                )
            )
        }
    }
} 