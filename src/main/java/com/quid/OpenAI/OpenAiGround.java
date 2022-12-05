package com.quid.OpenAI;

import com.theokanning.openai.completion.CompletionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OpenAiGround {

    private final AiService aiService;

    @PostMapping("/openAi")
    public CompletionResult ApiTest(@RequestBody String text) {
        return aiService.getAiTalk(text);
    }

}
