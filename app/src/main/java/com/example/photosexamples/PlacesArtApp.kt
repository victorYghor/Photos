package com.example.photosexamples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun PlacesArtApp(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Places.valueOf(
        backStackEntry?.destination?.route ?: Places.LINHA_DO_TIRO.name
    )

    NavHost(
        navController = navController,
        startDestination = Places.LINHA_DO_TIRO.name
    ) {
        composable(Places.LINHA_DO_TIRO.name) {
            PlaceScreen(
                image = R.drawable.linha_do_tiro,
                imageDescription = R.string.linha_do_tiro_image_description,
                title = R.string.linha_do_tiro,
                description = R.string.linha_do_tiro_description,
                navBack = { navController.navigate(Places.SITIO_DA_TRINDADE.name) },
                navForward = { navController.navigate(Places.PARQUE_DA_JAQUEIRA.name) }
            )
        }

        composable(Places.PARQUE_DA_JAQUEIRA.name){
            PlaceScreen(
                image = R.drawable.parque_jaqueira,
                imageDescription = R.string.parque_da_jaqueira_image_image_description,
                title = R.string.parque_da_jaqueira,
                description = R.string.parque_da_jaqueira_description,
                navBack = { navController.navigate(Places.LINHA_DO_TIRO.name)},
                navForward = { navController.navigate(Places.ORLA_DE_BOA_VIAGEM.name) }
            )
        }

        composable(Places.ORLA_DE_BOA_VIAGEM.name) {
            PlaceScreen(
                image = R.drawable.orla_de_boa_viagem,
                imageDescription = R.string.orla_de_boa_viagem_image_description,
                title = R.string.orla_de_boa_viagem,
                description = R.string.orla_de_boa_viagem_description,
                navBack = { navController.navigate(Places.PARQUE_DA_JAQUEIRA.name) },
                navForward = { navController.navigate(Places.SITIO_DA_TRINDADE.name) }
            )
        }

        composable(Places.SITIO_DA_TRINDADE.name) {
            PlaceScreen(
                image = R.drawable.sitio_da_trindade,
                imageDescription = R.string.sitio_da_trindade_image_description,
                title = R.string.sitio_da_trindade,
                description = R.string.sitio_da_tridade_description,
                navBack = { navController.navigate(Places.ORLA_DE_BOA_VIAGEM.name) },
                navForward = { navController.navigate(Places.LINHA_DO_TIRO.name) }
            )
        }
    }
}