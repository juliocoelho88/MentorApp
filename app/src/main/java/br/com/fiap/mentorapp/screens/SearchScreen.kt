package br.com.fiap.mentorapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.mentorapp.navigation.Screen
import br.com.fiap.mentorapp.viewmodel.MatchmakingViewModel

@Composable
fun SearchScreen(navController: NavHostController, matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    var location by remember { mutableStateOf("") }
    var expertise by remember { mutableStateOf("") }
    var availability by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pesquisa Avançada",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Localização") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = expertise,
            onValueChange = { expertise = it },
            label = { Text("Área de Expertise") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = availability,
            onValueChange = { availability = it },
            label = { Text("Disponibilidade") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                matchmakingViewModel.filterProfiles(location, expertise, availability)
                navController.navigate(Screen.SearchResults.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Pesquisar")
        }
    }
}
