package br.com.fiap.mentorapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorapp.enum.ProfileType
import br.com.fiap.mentorapp.screens.ChooseProfileTypeScreen
import br.com.fiap.mentorapp.screens.CreateProfileScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ChooseProfileType.route) {
        composable(Screen.ChooseProfileType.route) {
            ChooseProfileTypeScreen(navController = navController)
        }
        composable(Screen.CreateProfileMentor.route) {
            CreateProfileScreen(profileType = ProfileType.MENTOR, navController = navController)
        }
        composable(Screen.CreateProfileApprentice.route) {
            CreateProfileScreen(profileType = ProfileType.APPRENTICE, navController = navController)
        }
        // Adicione mais destinos (telas) conforme necessário
    }
}
