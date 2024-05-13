package br.com.fiap.fintech.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.mentorapp.model.UserProfile
import br.com.fiap.mentorapp.viewmodel.MatchmakingViewModel

@Composable
fun MatchmakingScreen(matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Matchmaking",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Lista de Mentores
        SectionTitle(title = "Mentores Disponíveis")
        UserList(userProfiles = matchmakingViewModel.mentors.value ?: emptyList())

        // Lista de Aprendizes
        SectionTitle(title = "Aprendizes Disponíveis")
        UserList(userProfiles = matchmakingViewModel.apprentices.value ?: emptyList())
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun UserList(userProfiles: List<UserProfile>) {
    LazyColumn {
        items(userProfiles) { userProfile ->
            UserProfileCard(userProfile = userProfile)
        }
    }
}

@Composable
fun UserProfileCard(userProfile: UserProfile) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Nome: ${userProfile.name}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Experiência: ${userProfile.experience}", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Habilidades: ${userProfile.skills.joinToString(", ")}", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Interesses: ${userProfile.interests.joinToString(", ")}", fontSize = 14.sp)
        }
    }
}
