
package com.chat.telegram_bot.repository;

import com.chat.telegram_bot.model.RespuestaBot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaBotRepository extends JpaRepository<RespuestaBot, Long> { 
    // Métodos de consulta adicionales si es necesario 
}
