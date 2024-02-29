package com.asugo.cookai;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CookingService {

    private final AiClient client;

    public Recipe findDish(CookCommand command) {
        return client.askAi(command);
    }
}
