
package com.chat.telegram_bot.service;

import com.chat.telegram_bot.model.Conversacion;
import com.chat.telegram_bot.repository.ConversacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConversacionService {

    @Autowired
    private ConversacionRepository conversacionRepository;

    // Crear una nueva conversación
    public Conversacion iniciarNuevaConversacion() {
        Conversacion conversacion = new Conversacion();
        return conversacionRepository.save(conversacion);
    }

    // Obtener una conversación por su ID
    public Optional<Conversacion> getConversacion(Long id) {
        return conversacionRepository.findById(id);
    }
}
