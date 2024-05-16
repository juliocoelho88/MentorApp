package br.com.fiap.mentorapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentorapp.model.UserProfile

@Composable
fun UserList(userProfiles: List<UserProfile>) {
    LazyColumn {
        items(userProfiles) { userProfile ->
            Text(
                text = userProfile.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            // Adicione mais informações do perfil conforme necessário
        }
    }
}