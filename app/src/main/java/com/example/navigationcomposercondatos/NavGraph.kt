package com.example.navigationcomposercondatos

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
        //startDestination = "HomeScreen"

    ) {
        composable(
            Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            Screen.Second.route,
            arguments = listOf(navArgument("nombre"){
                type=NavType.StringType
            },
            navArgument("autor"){
                type= NavType.StringType
            },
                navArgument("año"){
                    type= NavType.IntType
                },
                navArgument("descripcion"){
                    type= NavType.StringType
                },
                        navArgument("localizacion"){
                    type= NavType.StringType
                },
                navArgument("imagen"){
                    type= NavType.StringType
                }




            )
        ) { navBackStackEntry ->
            SecondScreen(navBackStackEntry.arguments?.getString("nombre")!! ,
             navBackStackEntry.arguments?.getString("autor")!!,
            navBackStackEntry.arguments?.getInt("año")!!,
                navBackStackEntry.arguments?.getString("descripcion")!!,
            navBackStackEntry.arguments?.getString("localizacion")!!,

            navBackStackEntry.arguments?.getString("imagen")!!)
        }
    }
}