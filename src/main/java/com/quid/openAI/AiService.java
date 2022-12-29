package com.quid.openAI;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

public interface AiService {

    CompletionResult getAiTalk(String text);

    @Service
    class AiServiceImpl implements AiService {

        @Value("${openAi.apiKey}")
        private static String key;

        @Override
        public CompletionResult getAiTalk(String text) {
            OpenAiService service = new OpenAiService(key);
            return service.createCompletion(getBuild(text));
        }

        private static CompletionRequest getBuild(String text) {
            return CompletionRequest.builder()
                .model("text-davinci-003")
                .temperature(0.7)
                .prompt(text)
                .maxTokens(256)
                .topP(1.0)
                .frequencyPenalty(0.0)
                .presencePenalty(0.0)
                .build();
        }
    }
}
