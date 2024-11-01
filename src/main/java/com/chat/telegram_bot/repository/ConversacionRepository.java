
package com.chat.telegram_bot.repository; 
 
import com.chat.telegram_bot.model.Conversacion; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
 
@Repository 
public interface ConversacionRepository extends JpaRepository<Conversacion, Long> { 
    // Aquí puedes agregar métodos de consulta adicionales si es necesario 
}