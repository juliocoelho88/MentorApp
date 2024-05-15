package br.com.fiap.mentorapp.util

object DataParser {
    fun parseSkills(skillsString: String): List<String> {
        return skillsString.split(",").map { it.trim() }
    }
}
