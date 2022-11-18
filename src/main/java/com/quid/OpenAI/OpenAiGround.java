package com.quid.OpenAI;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAiGround {

    @Value("${openAi.apiKey}")
    private String key;

    @PostMapping("/openAi")
    public CompletionResult ApiTest(@RequestBody String text) {
        OpenAiService service = new OpenAiService(key);
        CompletionRequest request = CompletionRequest.builder()
            .model("text-davinci-002")
            .temperature(0.7)
            .prompt(text)
            .maxTokens(256)
            .topP(1.0)
            .frequencyPenalty(0.0)
            .presencePenalty(0.0)
            .build();
        return service.createCompletion(request);
    }

}
