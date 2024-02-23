package com.asugo.cookai;

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
    private final OpenAiChatClient openAiChatClient;

    @PostMapping("/recipeSuggestions")
    Recipe suugestRecipe(@RequestBody CookAssistantRequest request) {
        BeanOutputParser<Recipe> parser = new BeanOutputParser<>(Recipe.class);

        PromptTemplate template = new PromptTemplate(CookAssistantRequest.promptString);
        template.add("skladniki", request.ingredients());
        template.add("dieta", request.diet());
        template.add("posilek", request.mealType());
        template.add("format", parser.getFormat());

        var prompt = template.create();
        var response = openAiChatClient.call(prompt);

        var content = response.getResult().getOutput().getContent();

        return parser.parse(content);
    }
}
