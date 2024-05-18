package br.com.fiap.mentorapp.screens

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.mentorapp.components.SectionTitle
import br.com.fiap.mentorapp.components.UserList
import br.com.fiap.mentorapp.navigation.Screen
import br.com.fiap.mentorapp.viewmodel.MatchmakingViewModel

@Composable
fun SearchResultsScreen(navController: NavHostController, matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    val mentors by matchmakingViewModel.filteredMentors
    val apprentices by matchmakingViewModel.filteredApprentices

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Resultados da Pesquisa",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        SectionTitle(title = "Mentores")
        UserList(userProfiles = mentors)

        SectionTitle(title = "Aprendizes")
        UserList(userProfiles = apprentices)

        Button(
            onClick = {
                navController.navigate(Screen.Matchmaking.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Voltar")
        }
    }
}
