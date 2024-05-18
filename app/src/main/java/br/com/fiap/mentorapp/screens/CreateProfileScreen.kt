package br.com.fiap.mentorapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mentorapp.enum.ProfileType
import br.com.fiap.mentorapp.model.UserProfile
import br.com.fiap.mentorapp.navigation.Screen
import br.com.fiap.mentorapp.viewmodel.MatchmakingViewModel

@Composable
fun CreateProfileScreen(
    navController: NavController,
    viewModel: MatchmakingViewModel,
    profileType: ProfileType
) {
    var name by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var interests by remember { mutableStateOf("") }
    var education by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Campos de entrada para o cadastro
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = experience,
            onValueChange = { experience = it },
            label = { Text("Experiência (Se Mentor: 2 anos, 5 anos, Se Aprendiz: estudante)") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = skills,
            onValueChange = { skills = it },
            label = { Text("Habilidades (separadas por vírgula)") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = interests,
            onValueChange = { interests = it },
            label = { Text("Interesses (separados por vírgula)") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = education,
            onValueChange = { education = it },
            label = { Text("Educação") },
            modifier = Modifier.fillMaxWidth()
        )

        // Botão para salvar o perfil
        Button(
            onClick = {
                val skillsList = skills.split(",").map { it.trim() }
                val interestsList = interests.split(",").map { it.trim() }

                val userProfile = UserProfile(
                    name = name,
                    experience = experience,
                    skills = skillsList,
                    interests = interestsList,
                    education = education
                )

                viewModel.addUserProfile(userProfile)


                // Navega de volta para a tela anterior
                navController.navigate(Screen.Matchmaking.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text("Salvar Perfil")
        }
    }
}

