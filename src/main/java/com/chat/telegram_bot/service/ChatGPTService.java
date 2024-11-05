
package com.chat.telegram_bot.service;

import com.chat.telegram_bot.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;

@Service
public class ChatGPTService {

    @Autowired
    private BotConfig botConfig;

    public String getChatGPTResponse(String prompt) {
        String apiUrl = "https://api.openai.com/v1/engines/davinci-codex/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + botConfig.getApiKey());
        headers.set("Content-Type", "application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("prompt", prompt);
        requestBody.put("max_tokens", 50);

        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);
        JSONObject responseBody = new JSONObject(response.getBody());

        return responseBody.getJSONArray("choices").getJSONObject(0).getString("text").trim();
    }
}
