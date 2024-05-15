package br.com.fiap.mentorapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import br.com.fiap.mentorapp.model.UserProfile

@Composable
fun MatchList(matches: List<Pair<UserProfile, UserProfile>>) {
    Column {
        Text("Matches Encontrados:")
        for (match in matches) {
            Column {
                Text("Mentor: ${match.first.name}")
                Text("Aprendiz: ${match.second.name}")
                // Adicione mais detalhes do match conforme necessário
                Text("Habilidades Compartilhadas:")
                for (skill in match.first.skills.intersect(match.second.skills)) {
                    Text("- $skill")
                }
                // Adicione mais detalhes conforme necessário
            }
        }
    }
}
