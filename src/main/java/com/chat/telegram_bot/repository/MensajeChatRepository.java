
package com.chat.telegram_bot.repository; 
 
import com.chat.telegram_bot.model.MensajeChat; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
 
@Repository 
public interface MensajeChatRepository extends JpaRepository<MensajeChat, Long> { 
    // Aquí puedes agregar métodos de consulta adicionales si es necesario 
}