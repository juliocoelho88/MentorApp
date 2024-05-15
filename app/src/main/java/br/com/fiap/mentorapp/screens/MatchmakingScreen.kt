package br.com.fiap.mentorapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.mentorapp.components.MatchList
import br.com.fiap.mentorapp.viewmodel.MatchmakingViewModel

@Composable
fun MatchmakingScreen(matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    val matches = matchmakingViewModel.matchProfiles()

    Column {
        Text("Lista de Matches:")
        if (matches.isNotEmpty()) {
            MatchList(matches = matches)
        } else {
            Text("Nenhum match encontrado.")
        }
    }
}
