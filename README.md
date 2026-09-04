# LacTech — Aplicativo Android (Kotlin + Jetpack Compose)

Aplicativo Android nativo em **Kotlin** desenvolvido com a moderna arquitetura **Jetpack Compose (Material 3)** para o projeto **LacTech**, focado no apoio ao programa **Lactare** (doação de leite humano).

---

## 📱 As 3 Telas do Aplicativo

### 1. 🏠 Tela Home (`HomeScreen.kt`)
- **Apresentação e Hero Banner:** Conscientização sobre a doação de leite materno com atalhos rápidos para o Chatbot e FAQ.
- **Seção "O que é?":** Explicação sobre o ato voluntário da doação para alimentar bebês prematuros em UTIs neonatais.
- **Seção "Quem Somos?":** Contexto do projeto LacTech em parceria e apoio ao programa Lactare (Eurofarma).
- **Impacto do Programa Lactare:** Cards interativos com os 6 principais dados estatísticos de impacto social.
- **Rodapé Institucional:** Direitos reservados e termos.

### 2. ❓ Tela FAQ (`FaqScreen.kt`)
- **Barra de Busca Instantânea:** Filtragem dinâmica de perguntas e respostas por palavras-chave.
- **Acordeão Interativo (Accordion):** Todas as 10 perguntas e respostas originais em cards expansíveis com animações suaves de rotação e expansão.
- **Controle Rápido:** Botão para "Expandir todas" ou "Recolher todas".

### 3. 🤖 Tela Chatbot - Lacty (`ChatbotScreen.kt` + `ChatViewModel.kt`)
- **Identidade do Robô Lacty:** Avatar desenhado em Canvas/Vetorial e indicador de status online.
- **Chips de Perguntas Rápidas:** Sugestões de dúvidas frequentes ("Como doar?", "Onde doar?", "É gratuito?", etc.) com envio em 1 toque.
- **Motor de Respostas Inteligente em Kotlin:** Sistema nativo de inferência de intenções e respostas contextuais, com indicador de digitação ("Lacty está digitando...") e rolagem automática da conversa.
- **Histórico e Limpeza:** Visualização de balões de mensagem estilizados e opção de reiniciar a conversa.

---

## 🏗️ Estrutura do Projeto

```
android/
├── build.gradle.kts                      # Configuração Gradle do projeto
├── settings.gradle.kts                   # Configurações de módulos e repositórios
├── gradle.properties                     # Propriedades de compilação JVM / AndroidX
├── app/
    ├── build.gradle.kts                  # Dependências: Compose, Material3, Navigation, ViewModel
    ├── src/main/
        ├── AndroidManifest.xml           # Manifesto do App
        ├── res/                          # Recursos (strings, colors, themes, xml)
        └── java/com/lactech/app/
            ├── MainActivity.kt           # Activity principal
            ├── data/                     # Modelos de dados e provedores
            │   ├── FaqItem.kt
            │   ├── ImpactCardItem.kt
            │   └── ChatMessage.kt
            ├── viewmodel/                # Lógica de negócio e estado reativo
            │   └── ChatViewModel.kt
            ├── ui/
                ├── theme/                # Paleta de cores, tipografia e tema
                │   ├── Color.kt
                │   ├── Type.kt
                │   └── Theme.kt
                ├── navigation/           # Rotas e gerenciamento de navegação
                │   ├── Screen.kt
                │   └── NavGraph.kt
                ├── components/           # Componentes reutilizáveis
                │   ├── AppTopBar.kt
                │   ├── AppBottomBar.kt
                │   ├── FaqAccordionCard.kt
                │   ├── ImpactCard.kt
                │   ├── ChatMessageBubble.kt
                │   └── LactyAvatar.kt
                └── screens/              # As 3 telas do app
                    ├── HomeScreen.kt
                    ├── FaqScreen.kt
                    └── ChatbotScreen.kt
```

---

## 🚀 Como Abrir e Executar no Android Studio

1. Abra o **Android Studio**.
2. Selecione **Open** e navegue até a pasta `d:\LacTech\android` (ou a pasta onde o projeto foi clonado).
3. Aguarde o **Gradle Sync** concluir o download das dependências.
4. Selecione um emulador (ou conecte seu smartphone com depuração USB habilitada).
5. Clique no botão **Run (▶)** (ou pressione `Shift + F10`).

