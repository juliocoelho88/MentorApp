package br.com.fiap.mentorapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorapp.enum.ProfileType
import br.com.fiap.mentorapp.screens.ChooseProfileTypeScreen
import br.com.fiap.mentorapp.screens.CreateProfileScreen
import br.com.fiap.mentorapp.screens.MatchmakingScreen
import br.com.fiap.mentorapp.screens.SearchResultsScreen
import br.com.fiap.mentorapp.screens.SearchScreen
import br.com.fiap.mentorapp.viewmodel.MatchmakingViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ChooseProfileType.route) {
        composable(Screen.ChooseProfileType.route) {
            ChooseProfileTypeScreen(navController = navController)
        }
        composable(Screen.CreateProfileMentor.route) {
            CreateProfileScreen(profileType = ProfileType.MENTOR, navController = navController, viewModel = MatchmakingViewModel())
        }
        composable(Screen.CreateProfileApprentice.route) {
            CreateProfileScreen(profileType = ProfileType.APPRENTICE, navController = navController, viewModel = MatchmakingViewModel())
        }
        composable(Screen.Matchmaking.route) {
            MatchmakingScreen(matchmakingViewModel = viewModel(), navController = navController)
        }
        composable(Screen.Search.route) {
            SearchScreen(navController)
        }
        composable(Screen.SearchResults.route) {
            SearchResultsScreen(navController)
        }
        // Adicione mais destinos (telas) conforme necessário
    }
}
