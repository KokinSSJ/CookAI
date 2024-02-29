package com.asugo.cookai;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class OpenAiClient implements AiClient {

    private final OpenAiChatClient openAiChatClient;


    public OpenAiClient(OpenAiChatClient openAiChatClient) {
        this.openAiChatClient = openAiChatClient;
    }

    static String promptString = """
                Na podstawie dostępnych składników: {skladniki},
                oraz z uwzględnieniem diety: {dieta}
                i preferowanego typu posiłku: {posilek},
                daj mi przepis kulinarny, który spełnia te kryteria.
                Nie musisz wykorzystywać wszystkich składników.
                Ponumeruj po kolei wszystkie etapy przygotowania posiłku.
                Odpowiedz po Polsku.
                Zwróć to w formacie: {format}
                """;

    @Override
    public Recipe askAi(CookCommand command) {

        BeanOutputParser<Recipe> parser = new BeanOutputParser<>(Recipe.class);

        PromptTemplate template = new PromptTemplate(promptString);
        template.add("skladniki", command.ingredients());
        template.add("dieta", command.diet());
        template.add("posilek", command.mealType());
        template.add("format", parser.getFormat());

        return parser.parse(openAiChatClient.call(template.create())
                .getResult()
                .getOutput()
                .getContent());
    }


}
