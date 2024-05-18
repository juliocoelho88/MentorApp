# MentorApp

MentorApp é um aplicativo móvel projetado para facilitar o matchmaking entre mentores e aprendizes com base em habilidades, interesses e experiências compartilhadas. Este README fornece um guia abrangente para entender o projeto, sua estrutura e como configurá-lo para desenvolvimento.

## Índice

1. [Introdução](#introdução)
2. [Funcionalidades](#funcionalidades)
3. [Arquitetura](#arquitetura)
4. [Instalação](#instalação)
5. [Uso](#uso)
6. [Telas](#telas)
7. [ViewModels](#viewmodels)
8. [Integração de Back-end Simulado](#integração-de-back-end-simulado)
9. [Trabalhos Futuros](#trabalhos-futuros)
10. [Contribuição](#contribuição)
11. [Licença](#licença)

## Introdução

MentorApp é construído usando Jetpack Compose para a interface do usuário e segue o padrão arquitetural MVVM (Model-View-ViewModel). O aplicativo permite que os usuários criem perfis como mentores ou aprendizes e os combina com base em critérios predefinidos.

## Funcionalidades

- **Criação de Perfil**: Usuários podem criar perfis especificando suas habilidades, interesses, experiência e educação.
- **Matchmaking**: Combina mentores e aprendizes com base em habilidades e interesses compartilhados.
- **Pesquisa Avançada**: Permite filtrar mentores e aprendizes com base em critérios específicos (implementação futura).
- **Notificações Push**: Simula notificações para novos matches, mensagens e solicitações de reunião (implementação futura).

## Arquitetura

O aplicativo segue a arquitetura MVVM, onde:

- **Model**: Representa os dados e a lógica de negócios.
- **View**: Componentes de UI que exibem os dados.
- **ViewModel**: Atua como uma ponte entre o Model e o View, gerenciando dados relacionados à UI.

## Instalação

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seuusuario/MentorApp.git
   cd MentorApp
   ```

2. **Abra o projeto no Android Studio:**
   - Certifique-se de ter a versão mais recente do Android Studio instalada.
   - Abra o projeto a partir do diretório clonado.

3. **Compile e Execute:**
   - Compile o projeto para garantir que todas as dependências sejam baixadas.
   - Execute o aplicativo em um emulador ou dispositivo físico.

## Uso

1. **Escolha o Tipo de Perfil:**
   - Na tela principal, escolha "Mentor" ou "Aprendiz" para criar um perfil.

2. **Criação de Perfil:**
   - Preencha os detalhes necessários como nome, experiência, habilidades, interesses e educação.

3. **Matchmaking:**
   - Após criar um perfil, você será direcionado para a tela de matchmaking onde poderá ver os matches baseados no seu perfil.

## Telas

### ChooseProfileTypeScreen

Permite aos usuários selecionar entre criar um perfil de mentor ou aprendiz.

```kotlin
@Composable
fun ChooseProfileTypeScreen(navController: NavHostController) {
    // Implementação da UI...
}
```

### CreateProfileMentorScreen

Permite aos usuários criar um perfil de mentor preenchendo um formulário.

```kotlin
@Composable
fun CreateProfileMentorScreen(navController: NavHostController, matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    // Implementação da UI...
}
```

### CreateProfileApprenticeScreen

Permite aos usuários criar um perfil de aprendiz preenchendo um formulário.

```kotlin
@Composable
fun CreateProfileApprenticeScreen(navController: NavHostController, matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    // Implementação da UI...
}
```

### MatchmakingScreen

Exibe a lista de mentores e aprendizes, e mostra os matches com base nos critérios.

```kotlin
@Composable
fun MatchmakingScreen(navController: NavHostController, matchmakingViewModel: MatchmakingViewModel = viewModel()) {
    // Implementação da UI...
}
```

## ViewModels

### MatchmakingViewModel

Lida com a lógica de negócios para adicionar perfis e realizar o matchmaking.

```kotlin
class MatchmakingViewModel : ViewModel() {
    // Implementação...
}
```

## Integração de Back-end Simulado

Como o projeto foca na simulação do front-end, as chamadas de back-end são representadas por manipulações de dados locais dentro dos ViewModels. Por exemplo, `performMatchmaking` em `MatchmakingViewModel` simula o processamento de dados e a lógica de matching.

### Exemplo:

```kotlin
fun performMatchmaking(mentors: List<UserProfile>, apprentices: List<UserProfile>): List<Pair<UserProfile, UserProfile>> {
    // Lógica de matchmaking simulada...
}
```

## Trabalhos Futuros

- Implementar funcionalidade de Pesquisa Avançada.
- Integrar Notificações Push.
- Aprimorar o algoritmo de matchmaking.
- Desenvolver um serviço de back-end real para persistência e recuperação de dados.

## Contribuição

1. Faça um fork do repositório.
2. Crie uma nova branch (`git checkout -b feature-branch`).
3. Faça suas alterações e commit (`git commit -m 'Adicionar nova funcionalidade'`).
4. Faça o push para a branch (`git push origin feature-branch`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

Sinta-se à vontade para contribuir para este projeto enviando issues ou pull requests. Para qualquer dúvida ou feedback, entre em contato com o mantenedor do projeto.

---

### Contato

- Email: seu-email@example.com
- GitHub: [seuusuario](https://github.com/seuusuario)
