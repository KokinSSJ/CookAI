package com.asugo.cookai;

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

    @Bean
    public AiClient createAiClient(OpenAiChatClient openAiChatClient) {
        return new OpenAiClient(openAiChatClient);
    }
}
