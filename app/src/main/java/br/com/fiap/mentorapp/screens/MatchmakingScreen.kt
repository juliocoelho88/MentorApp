package br.com.fiap.mentorapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.mentorapp.components.NotificationList
import br.com.fiap.mentorapp.components.SectionTitle
import br.com.fiap.mentorapp.components.UserList
import br.com.fiap.mentorapp.navigation.Screen
import br.com.fiap.mentorapp.viewmodel.MatchmakingViewModel


@Composable
fun MatchmakingScreen(navController: NavHostController, matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    val mentors by matchmakingViewModel.filteredMentors
    val apprentices by matchmakingViewModel.filteredApprentices
    val matches by matchmakingViewModel.matches
    val notifications = matchmakingViewModel.notifications

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Exibição dos mentores e aprendizes
        SectionTitle(title = "Resultados do Matchmaking - Mentores")
        UserList(userProfiles = mentors)

        SectionTitle(title = "Resultados do Matchmaking - Aprendizes")
        UserList(userProfiles = apprentices)

        // Botão para executar o matchmaking
        Button(
            onClick = { matchmakingViewModel.performMatchmaking() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Executar Matchmaking")
        }

        // Exibição dos matches
        SectionTitle(title = "Matches Encontrados:")
        matches.forEach { (mentor, apprentice) ->
            Column {
                Text("Mentor: ${mentor.name}")
                Text("Aprendiz: ${apprentice.name}")
                Text("Habilidades Compartilhadas: ${mentor.skills.intersect(apprentice.skills)}")
            }
        }
        // Exibição das notificações
        NotificationList(notifications = notifications)

        // Botão para ir até a busca
        Button(
            onClick = { navController.navigate(Screen.Search.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Buscar")
        }

    }
}
