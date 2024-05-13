package br.com.fiap.mentorapp.model

data class UserProfile(
    val name: String,
    val experience: String,
    val skills: List<String>,
    val interests: List<String>
)
