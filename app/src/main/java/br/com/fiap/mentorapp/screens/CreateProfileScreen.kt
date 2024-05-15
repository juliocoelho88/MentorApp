package br.com.fiap.mentorapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mentorapp.enum.ProfileType

@Composable
fun CreateProfileScreen(navController: NavController, profileType: ProfileType) {
    // Lógica para criar perfil
    var name by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var interests by remember { mutableStateOf("") }
    var formation by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Criar Perfil", fontSize = 24.sp)

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") }
        )

        TextField(
            value = experience,
            onValueChange = { experience = it },
            label = { Text("Experiência") }
        )

        TextField(
            value = skills,
            onValueChange = { skills = it },
            label = { Text("Habilidades") }
        )

        TextField(
            value = interests,
            onValueChange = { interests = it },
            label = { Text("Interesses") }
        )

        TextField(
            value = formation,
            onValueChange = { formation = it },
            label = { Text("Formação Acadêmica") }
        )

        Button(
            onClick = {
                // Aqui você pode processar os dados do formulário
                val name = name
                val experience = experience
                val skills = skills
                val interests = interests
                val fomation = formation

                // Exemplo: Enviar dados para ViewModel ou fazer outra ação necessária
                // matchmakingViewModel.createProfile(name, experience, skills, interests)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Salvar")
        }
    }
}
