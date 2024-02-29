package com.asugo.cookai;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CookAiController {

    CookingService service;

    @PostMapping("/recipeSuggestions")
    public Recipe sugestRecipe(@Valid @RequestBody CookAssistantRequest cookRequest) {
        CookCommand request = CookCommand.from(cookRequest);
        return service.findDish(request);
    }
}
