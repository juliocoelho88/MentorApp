package br.com.fiap.fintech.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateProfileScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var interests by remember { mutableStateOf("") }
    var education by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Crie seu Perfil",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                TextInputField(value = name, onValueChange = { name = it }, label = "Nome")
                Spacer(modifier = Modifier.height(8.dp))
                TextInputField(value = email, onValueChange = { email = it }, label = "Email")
                Spacer(modifier = Modifier.height(8.dp))
                TextInputField(value = experience, onValueChange = { experience = it }, label = "Experiência")
                Spacer(modifier = Modifier.height(8.dp))
                TextInputField(value = skills, onValueChange = { skills = it }, label = "Habilidades")
                Spacer(modifier = Modifier.height(8.dp))
                TextInputField(value = interests, onValueChange = { interests = it }, label = "Áreas de Interesse")
                Spacer(modifier = Modifier.height(8.dp))
                TextInputField(value = education, onValueChange = { education = it }, label = "Formação Acadêmica")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Aqui você pode processar os dados do perfil
                println("Perfil criado:")
                println("Nome: $name")
                println("Email: $email")
                println("Experiência: $experience")
                println("Habilidades: $skills")
                println("Áreas de Interesse: $interests")
                println("Formação Acadêmica: $education")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Salvar Perfil")
        }
    }
}

@Composable
fun TextInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = label, fontSize = 14.sp)
            androidx.compose.material3.TextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 16.sp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            )
        }
    }
}
