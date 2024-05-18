package br.com.fiap.mentorapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.fiap.mentorapp.api.MockApiService
import br.com.fiap.mentorapp.model.UserProfile

class MatchmakingViewModel : ViewModel() {

    private val apiService = MockApiService()

    // Listas de mentores e aprendizes
    private val mentors = mutableStateListOf<UserProfile>()
    private val apprentices = mutableStateListOf<UserProfile>()

    // Listas filtradas
    private val _filteredMentors = mutableStateOf<List<UserProfile>>(emptyList())
    private val _filteredApprentices = mutableStateOf<List<UserProfile>>(emptyList())

    // Getter para expor as listas filtradas como State
    val filteredMentors: State<List<UserProfile>> get() = _filteredMentors
    val filteredApprentices: State<List<UserProfile>> get() = _filteredApprentices

    // Lista de matches
    private val _matches = mutableStateOf<List<Pair<UserProfile, UserProfile>>>(emptyList())
    val matches: State<List<Pair<UserProfile, UserProfile>>> get() = _matches

    // Lista de notificações
    private val _notifications = mutableStateListOf<String>()
    val notifications: List<String> get() = _notifications

    init {
        loadUserProfiles()
    }

    private fun loadUserProfiles() {
        mentors.addAll(apiService.getMentors())
        apprentices.addAll(apiService.getApprentices())
    }

    // Função para adicionar mentores e aprendizes
    fun addUserProfile(userProfile: UserProfile) {
        if (userProfile.skills.contains("anos")) {
            mentors.add(userProfile)
        } else {
            apprentices.add(userProfile)
        }
    }

    // Função de filtragem
    fun filterProfiles(location: String, expertise: String, availability: String) {
        _filteredMentors.value = mentors.filter { mentor ->
            (location.isEmpty() || mentor.experience.contains(location, true)) &&
                    (expertise.isEmpty() || mentor.skills.any { it.contains(expertise, true) }) &&
                    (availability.isEmpty() || mentor.experience.contains(availability, true))
        }

        _filteredApprentices.value = apprentices.filter { apprentice ->
            (location.isEmpty() || apprentice.experience.contains(location, true)) &&
                    (expertise.isEmpty() || apprentice.skills.any { it.contains(expertise, true) }) &&
                    (availability.isEmpty() || apprentice.experience.contains(availability, true))
        }
    }

    // Função de matchmaking
    fun performMatchmaking() {
        val newMatches = mutableListOf<Pair<UserProfile, UserProfile>>()

        for (mentor in mentors) {
            for (apprentice in apprentices) {
                if (mentor.skills.intersect(apprentice.skills).isNotEmpty() &&
                    mentor.interests.intersect(apprentice.interests).isNotEmpty()) {
                    newMatches.add(mentor to apprentice)
                }
            }
        }

        _matches.value = newMatches

        // Simulação de notificação push para novos matches
        if (newMatches.isNotEmpty()) {
            newMatches.forEach { match ->
                sendNotification("Novo match encontrado: Mentor ${match.first.name} e Aprendiz ${match.second.name}")
            }
        }
    }

    // Função para simular o envio de notificações
    private fun sendNotification(message: String) {
        _notifications.add(message)
        apiService.sendNotification(message)
    }
}
