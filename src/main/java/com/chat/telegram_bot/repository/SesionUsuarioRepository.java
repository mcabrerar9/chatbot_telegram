
package com.chat.telegram_bot.repository;

import com.chat.telegram_bot.model.SesionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionUsuarioRepository extends JpaRepository<SesionUsuario, Long> { 
    // Métodos de consulta adicionales si es necesario 
}
