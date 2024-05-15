package br.com.fiap.mentorapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.mentorapp.navigation.Screen

@Composable
fun ChooseProfileTypeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Nome da empresa (MentorApp) com tamanho maior e negrito
        Text(
            text = "MentorApp",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 64.dp)
        )

        // Botões para escolher o tipo de perfil (Mentor ou Aprendiz)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Botão Mentor
            Button(
                onClick = {
                    navController.navigate(Screen.CreateProfileMentor.route)
                },
                modifier = Modifier
                    .height(72.dp)
                    .width(160.dp), // Largura fixa para o botão
                colors = ButtonDefaults.buttonColors(Color.Blue),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "MENTOR",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Botão Aprendiz
            Button(
                onClick = {
                    navController.navigate(Screen.CreateProfileApprentice.route)
                },
                modifier = Modifier
                    .height(72.dp)
                    .width(160.dp), // Largura fixa para o botão
                colors = ButtonDefaults.buttonColors(Color.Blue),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "APRENDIZ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

