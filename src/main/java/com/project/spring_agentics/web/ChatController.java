package com.project.spring_agentics.web;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
@CrossOrigin("*")
public class ChatController {

    @Value("${gemini.api.key}") // Récupération de la clé API depuis application.properties
    private String apiKey;

    private ChatLanguageModel gemini;

    // Initialisation après l'injection de la clé API
    @PostConstruct
    public void init() {
        this.gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-1.5-flash")
                .build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(defaultValue = "bonjour gemini") String request) {
        return gemini.chat(request); // Méthode correcte pour générer la réponse
    }

}
