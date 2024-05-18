package br.com.fiap.mentorapp.navigation
sealed class Screen(val route: String) {
    object ChooseProfileType : Screen("choose_profile_type")
    object CreateProfileMentor : Screen("create_profile_mentor")
    object CreateProfileApprentice : Screen("create_profile_apprentice")
    object Matchmaking : Screen("matchmaking")
    object Search : Screen("search")
    object SearchResults : Screen("search_results")
    // Adicione mais telas conforme necessário
}


