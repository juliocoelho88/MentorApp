package br.com.fiap.mentorapp.api

import br.com.fiap.mentorapp.model.UserProfile

class MockApiService {

    fun getMentors(): List<UserProfile> {
        // Retorna uma lista de mentores fictícios
        return listOf(
            UserProfile("Mentor 1", "5 anos de experiência", listOf("Kotlin", "Java"), listOf("Mobile", "Backend"), "Universidade A"),
            UserProfile("Mentor 2", "3 anos de experiência", listOf("Python", "C++"), listOf("Data Science", "Machine Learning"), "Universidade B")
        )
    }

    fun getApprentices(): List<UserProfile> {
        // Retorna uma lista de aprendizes fictícios
        return listOf(
            UserProfile("Aprendiz 1", "1 ano de experiência", listOf("Swift", "Objective-C"), listOf("Mobile"), "Universidade C"),
            UserProfile("Aprendiz 2", "2 anos de experiência", listOf("Python", "JavaScript"), listOf("Frontend", "Backend"), "Universidade D")
        )
    }

    fun sendNotification(message: String) {
        // Simula o envio de uma notificação
        println("Notificação enviada: $message")
    }
}
