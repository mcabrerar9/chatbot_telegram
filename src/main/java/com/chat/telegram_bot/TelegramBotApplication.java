
package com.chat.telegram_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.chat.telegram_bot")
@EnableJpaRepositories("com.chat.telegram_bot.repository")
@EntityScan("com.chat.telegram_bot.model")
public class TelegramBotApplication {   
    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class, args);    
    }
}
