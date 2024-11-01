
package com.chat.telegram_bot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfig {
    
    @Value("${telegram.bot.token}")
    private String botToken;
    
    @Value("${telegram.bot.username}")
    private String botUsername;
    
    @Value("${openai.api.key}")
    private String apiKey;
    
    public String getBotToken() {
        return botToken;    
    }
    
    public String getBotUsername() {
        return botUsername;    
    }
    
    public String getApiKey() {
        return apiKey;    
    }
}