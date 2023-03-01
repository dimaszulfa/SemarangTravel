package com.arcquila.semarangtravel

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.get
import androidx.navigation.navArgument
import com.arcquila.semarangtravel.ui.detail.DetailScreen
import com.arcquila.semarangtravel.ui.home.HomeScreen
import com.arcquila.semarangtravel.ui.navigation.NavigationItem
import com.arcquila.semarangtravel.ui.navigation.Screen
import com.arcquila.semarangtravel.ui.about.AboutScreen
import com.arcquila.semarangtravel.ui.theme.SemarangTourismTheme
import com.arcquila.semarangtravel.ui.theme.black60


@Composable
fun SemarangTourismApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Detail.route && currentRoute != Screen.AboutMe.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { tourismId ->
                        navController.navigate(
                            Screen.Detail.createRoute(
                                tourismId
                            )
                        )
                    }
                )
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                )
            ) {
                val id = it.arguments?.getInt("id") ?: -1
                DetailScreen(
                    tourismId = id,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable(Screen.AboutMe.route) {
                AboutScreen(
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

@Composable
private fun BottomBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
    ) {
        val navigationItems = listOf(
            NavigationItem(
                screen = Screen.Home,
                title = stringResource(id = R.string.menu_home),
                icon = painterResource(id = R.drawable.ic_home)
            ),
            NavigationItem(
                screen = Screen.AboutMe,
                title = stringResource(id = R.string.about_me),
                icon = painterResource(id = R.drawable.ic_account_circle)
            )
        )
        BottomNavigation(
            backgroundColor = Color.White
        ) {
            val currentRoute = currentRoute(navHostController)

            navigationItems.map { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = item.icon,
                            contentDescription = item.title,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            style = SemarangTourismTheme.typography.caption,
                            fontSize = 11.sp
                        )
                    },
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navHostController.navigate(item.screen.route) {
                            popUpTo(navHostController.graph[Screen.Home.route].id) {
                                saveState = false
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    selectedContentColor = MaterialTheme.colors.primary,
                    unselectedContentColor = black60
                )
            }
        }
    }
}

@Composable
private fun currentRoute(navHostController: NavHostController): String? {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Preview(showBackground = true)
@Composable
fun SemarangTourismAppPreview() {
    SemarangTourismTheme {
        SemarangTourismApp()
    }
}