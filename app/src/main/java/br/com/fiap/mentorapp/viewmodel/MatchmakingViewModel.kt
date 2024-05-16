package br.com.fiap.mentorapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.fiap.mentorapp.model.UserProfile

class MatchmakingViewModel : ViewModel() {

    // Listas de mentores e aprendizes
    private val mentors = mutableListOf<UserProfile>()
    private val apprentices = mutableListOf<UserProfile>()

    // Listas filtradas de mentores e aprendizes após o matchmaking
    val filteredMentors = mutableStateOf<List<UserProfile>>(emptyList())
    val filteredApprentices = mutableStateOf<List<UserProfile>>(emptyList())

    // Função para adicionar mentores
    fun addUserProfile(userProfile: UserProfile) {
        // Critérios para diferenciar mentor de aprendiz
        val isMentor = userProfile.experience.contains("anos") // Exemplo: considera um mentor se tiver "anos" de experiência

        if (isMentor) {
            mentors.add(userProfile)
        } else {
            apprentices.add(userProfile)
        }
    }
    fun getMentors(): List<UserProfile> {
        return mentors
    }

    // Função para acessar a lista de aprendizes
    fun getApprentices(): List<UserProfile> {
        return apprentices
    }

    // Função de matchmaking
    fun performMatchmaking(mentors: List<UserProfile>, apprentices: List<UserProfile>): List<Pair<UserProfile, UserProfile>> {
        val matches = mutableListOf<Pair<UserProfile, UserProfile>>()

        for (mentor in mentors) {
            for (apprentice in apprentices) {
                if (mentor.skills.intersect(apprentice.skills).isNotEmpty() &&
                    mentor.interests.intersect(apprentice.interests).isNotEmpty() &&
                    mentor.experience.contains("anos") && apprentice.experience.contains("estudante")) {
                    matches.add(mentor to apprentice)
                }
            }
        }

        return matches
    }
}



