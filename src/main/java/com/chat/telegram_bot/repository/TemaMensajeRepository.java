
package com.chat.telegram_bot.repository;

import com.chat.telegram_bot.model.TemaMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaMensajeRepository extends JpaRepository<TemaMensaje, Long> { 
    // Métodos de consulta adicionales si es necesario 
}
