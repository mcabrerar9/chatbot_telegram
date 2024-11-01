
package com.chat.telegram_bot.bot; 
 
import com.chat.telegram_bot.config.BotConfig; 
import com.chat.telegram_bot.service.ChatGPTService; 
import org.telegram.telegrambots.bots.TelegramLongPollingBot; 
import org.telegram.telegrambots.meta.api.methods.send.SendMessage; 
import org.telegram.telegrambots.meta.api.objects.Update; 
import org.telegram.telegrambots.meta.exceptions.TelegramApiException; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component; 

 
import java.util.HashMap; 
import java.util.Map; 
 
@Component 
public class TelegramBot extends TelegramLongPollingBot { 
 
    @Autowired 
    private BotConfig botConfig; 
 
    @Autowired 
    private ChatGPTService chatGPTService; 
 
    private final Map<String, String> predefinedResponses; 
 
    public TelegramBot() { 
        predefinedResponses = new HashMap<>(); 
        predefinedResponses.put("hola", "¡Hola! ¿Cómo puedo ayudarte hoy?");
        predefinedResponses.put("¿cómo estás?", "Estoy aquí para ayudarte, ¡gracias por preguntar!");
        predefinedResponses.put("¿qué puedes hacer?", "Puedo responder preguntas y ayudarte con tus dudas.");
        predefinedResponses.put("¿quién te creó?", "Fui creado por Marjorie.");
        predefinedResponses.put("¿cuál es tu nombre?", "Soy un bot de Telegram desarrollado para asistirte.");
        predefinedResponses.put("¿qué es Java?", "Java es un lenguaje de programación orientado a objetos y multiplataforma.");
        predefinedResponses.put("¿qué es la inteligencia artificial?", "Es la simulación de inteligencia humana en máquinas.");
        predefinedResponses.put("cuéntame un chiste", "¿Por qué los programadores odian el sol? ¡Porque hay demasiados bugs!");
        predefinedResponses.put("¿qué es una API?", "Una API es una interfaz que permite la comunicación entre diferentes programas.");
        predefinedResponses.put("¿qué es la nube?", "La nube es un servicio de almacenamiento y procesamiento de datos en servidores remotos.");
        predefinedResponses.put("¿qué es un algoritmo?", "Es un conjunto de instrucciones paso a paso para realizar una tarea.");
        predefinedResponses.put("dime una curiosidad", "¿Sabías que el primer programa fue creado por Ada Lovelace en el siglo XIX?");
        predefinedResponses.put("¿cuál es la capital de Francia?", "La capital de Francia es París.");
        predefinedResponses.put("¿qué es el aprendizaje automático?", "Es una rama de la IA que permite a las máquinas aprender de los datos.");
        predefinedResponses.put("dame un consejo", "Recuerda siempre tener un respaldo de tu trabajo. ¡La prevención es clave!");
        predefinedResponses.put("¿qué es un bot?", "Un bot es un software que ejecuta tareas automáticas en internet.");
        predefinedResponses.put("dame una recomendación de programación", "Prueba escribir código limpio y bien comentado. ¡Facilitará el mantenimiento!");
        predefinedResponses.put("¿qué es la programación orientada a objetos?", "Es un paradigma que organiza el código en 'objetos' que representan conceptos o entidades.");
        predefinedResponses.put("¿qué significa API?", "API es la sigla de 'Interfaz de Programación de Aplicaciones', una forma en que los programas interactúan.");
        predefinedResponses.put("¿qué es el Big Data?", "Es el análisis y gestión de grandes volúmenes de datos para encontrar patrones y tendencias.");
    } 
 
    @Override 
    public String getBotToken() { 
        return botConfig.getBotToken(); 
    } 
 
    @Override 
    public String getBotUsername() { 
        return botConfig.getBotUsername(); 
    } 
 
    @Override 
    public void onUpdateReceived(Update update) { 
        if (update.hasMessage() && update.getMessage().hasText()) { 
            String messageText = update.getMessage().getText(); 
            long chatId = update.getMessage().getChatId(); 
 
            String response = processMessage(messageText); 
 
            SendMessage message = new SendMessage(); 
            message.setChatId(String.valueOf(chatId)); 
            message.setText(response); 
 
            try { 
                execute(message); 
            } catch (TelegramApiException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
 
    private String processMessage(String messageText) { 
        if (predefinedResponses.containsKey(messageText.toLowerCase())) { 
            return predefinedResponses.get(messageText.toLowerCase()); 
        } 
        return chatGPTService.getChatGPTResponse(messageText); 
    } 
}