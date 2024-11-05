
package com.chat.telegram_bot.repository;

import com.chat.telegram_bot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 
    Usuario findByNombreUsuario(String nombreUsuario);
}
