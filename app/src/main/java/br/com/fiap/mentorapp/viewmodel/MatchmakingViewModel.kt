package br.com.fiap.mentorapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.mentorapp.model.UserProfile

class MatchmakingViewModel : ViewModel() {
    private val _mentors = MutableLiveData<List<UserProfile>>()
    val mentors: LiveData<List<UserProfile>> = _mentors

    private val _apprentices = MutableLiveData<List<UserProfile>>()
    val apprentices: LiveData<List<UserProfile>> = _apprentices

    private val _filteredMentors = MutableLiveData<List<UserProfile>>()
    val filteredMentors: LiveData<List<UserProfile>> = _filteredMentors

    private val _filteredApprentices = MutableLiveData<List<UserProfile>>()
    val filteredApprentices: LiveData<List<UserProfile>> = _filteredApprentices

    init {
        // Inicializa as listas de mentores e aprendizes (simulação de dados estáticos)
        _mentors.value = listOf(
            UserProfile("Mentor 1", "Experiente", listOf("Java", "Kotlin"), listOf("Desenvolvimento Mobile")),
            UserProfile("Mentor 2", "Sênior", listOf("Android", "Firebase"), listOf("Arquitetura de Software"))
        )

        _apprentices.value = listOf(
            UserProfile("Aprendiz 1", "Iniciante", listOf("HTML", "CSS"), listOf("Web Design")),
            UserProfile("Aprendiz 2", "Intermediário", listOf("Python", "JavaScript"), listOf("Data Science"))
        )
    }

    // Filtra os mentores pela área de expertise selecionada
    fun filterMentorsByExpertise(expertise: String): List<UserProfile> {
        return _mentors.value?.filter { it.interests.contains(expertise) } ?: emptyList()
    }

    // Filtra os aprendizes por localização e disponibilidade
    fun filterApprenticesByCriteria(location: String, availability: String): List<UserProfile> {
        return _apprentices.value?.filter { apprentice ->
            // Lógica de filtragem personalizada com base nos critérios
            apprentice.skills.contains(location) && apprentice.experience.contains(availability)
        } ?: emptyList()
    }

    // Define a lista de mentores filtrada
    fun setFilteredMentors(filteredMentors: List<UserProfile>) {
        _filteredMentors.value = filteredMentors
    }

    // Define a lista de aprendizes filtrada
    fun setFilteredApprentices(filteredApprentices: List<UserProfile>) {
        _filteredApprentices.value = filteredApprentices
    }
}

