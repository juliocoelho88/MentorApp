package br.com.fiap.mentorapp.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.fintech.screens.SectionTitle
import br.com.fiap.fintech.screens.TextInputField
import br.com.fiap.fintech.screens.UserList
import br.com.fiap.mentorapp.viewmodel.MatchmakingViewModel

@Composable
fun AdvancedSearchScreen(matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    // Estado para armazenar a área de expertise selecionada
    val selectedExpertise = remember { mutableStateOf("") }
    val selectedLocation = remember { mutableStateOf("") }
    val selectedAvailability = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Pesquisa Avançada",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Dropdown para selecionar a área de expertise
        DropdownMenu(
            expanded = true, // Altere para true para exibir o menu
            onDismissRequest = { /* Sem ação ao fechar o menu */ }
        ) {
            DropdownMenuItem(text = {"Desenvolvimento Web"}, onClick = {selectedExpertise.value = "Desenvolvimento Web"})
            DropdownMenuItem(text = {"Arquitetura de Software"}, onClick = {selectedExpertise.value = "Arquitetura de Software"})
        }

        // Exibir a área de expertise selecionada
        Text(
            text = "Área de Expertise Selecionada: ${selectedExpertise.value}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Critérios de pesquisa: Localização
        TextInputField(value = selectedLocation.value, onValueChange = { selectedLocation.value = it }, label = "Localização")

        // Critérios de pesquisa: Disponibilidade
        TextInputField(value = selectedAvailability.value, onValueChange = { selectedAvailability.value = it }, label = "Disponibilidade")

        // Botão de Pesquisa
        Button(
            onClick = {
                // Filtrar mentores e aprendizes com base nos critérios selecionados
                val filteredMentors = matchmakingViewModel.filterMentorsByExpertise(selectedExpertise.value)
                val filteredApprentices = matchmakingViewModel.filterApprenticesByCriteria(selectedLocation.value, selectedAvailability.value)

                // Atualizar listas de mentores e aprendizes no ViewModel
                matchmakingViewModel.setFilteredMentors(filteredMentors)
                matchmakingViewModel.setFilteredApprentices(filteredApprentices)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Pesquisar")
        }

        // Resultados da Pesquisa
        SectionTitle(title = "Resultados da Pesquisa - Mentores")
        UserList(userProfiles = matchmakingViewModel.filteredMentors.value ?: emptyList())

        SectionTitle(title = "Resultados da Pesquisa - Aprendizes")
        UserList(userProfiles = matchmakingViewModel.filteredApprentices.value ?: emptyList())
    }
}
