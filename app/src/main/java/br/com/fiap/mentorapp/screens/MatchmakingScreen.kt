package br.com.fiap.mentorapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.fiap.mentorapp.components.SectionTitle
import br.com.fiap.mentorapp.components.UserList
import br.com.fiap.mentorapp.viewmodel.MatchmakingViewModel


@Composable
fun MatchmakingScreen(navController: NavController, matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    val mentors by matchmakingViewModel.filteredMentors
    val apprentices by matchmakingViewModel.filteredApprentices

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SectionTitle(title = "Resultados do Matchmaking - Mentores")
        UserList(userProfiles = mentors)

        SectionTitle(title = "Resultados do Matchmaking - Aprendizes")
        UserList(userProfiles = apprentices)

        Button(
            onClick = {
                matchmakingViewModel.performMatchmaking(mentors, apprentices)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Executar Matchmaking")
        }
    }
}


