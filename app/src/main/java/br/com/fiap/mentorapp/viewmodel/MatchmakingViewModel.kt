package br.com.fiap.mentorapp.viewmodel

import androidx.lifecycle.ViewModel
import br.com.fiap.mentorapp.model.UserProfile

class MatchmakingViewModel : ViewModel() {
    private val mentors = mutableListOf<UserProfile>()
    private val apprentices = mutableListOf<UserProfile>()

    fun addMentor(profile: UserProfile) {
        mentors.add(profile)
    }

    fun addApprentice(profile: UserProfile) {
        apprentices.add(profile)
    }

    fun matchProfiles(): List<Pair<UserProfile, UserProfile>> {
        val matches = mutableListOf<Pair<UserProfile, UserProfile>>()

        for (mentor in mentors) {
            val mentorSkills = mentor.skills
            for (apprentice in apprentices) {
                val apprenticeSkills = apprentice.skills
                // Lógica de match: comparação de skills, interesses, etc.
                // Adicione aqui a lógica para determinar se há um match entre mentor e aprendiz
                if (canMatch(mentorSkills, apprenticeSkills)) {
                    matches.add(Pair(mentor, apprentice))
                }
            }
        }

        return matches
    }

    private fun canMatch(mentorSkills: List<String>, apprenticeSkills: List<String>): Boolean {
        // Implemente a lógica de match aqui
        // Por exemplo, verifique se há pelo menos uma skill em comum
        return mentorSkills.any { it in apprenticeSkills }
    }
}
