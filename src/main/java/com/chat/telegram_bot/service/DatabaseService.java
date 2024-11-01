
package com.chat.telegram_bot.service;

import com.chat.telegram_bot.model.MensajeChat;
import com.chat.telegram_bot.model.Conversacion;
import com.chat.telegram_bot.model.Relevancia;
import com.chat.telegram_bot.model.Usuario;
import com.chat.telegram_bot.model.TemaMensaje;
import com.chat.telegram_bot.repository.UsuarioRepository;
import com.chat.telegram_bot.repository.MensajeChatRepository;
import com.chat.telegram_bot.repository.ConversacionRepository;
import com.chat.telegram_bot.repository.TemaMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DatabaseService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MensajeChatRepository mensajeChatRepository;

    @Autowired
    private ConversacionRepository conversacionRepository;

    @Autowired
    private TemaMensajeRepository temaMensajeRepository;

    // Método para guardar o actualizar un usuario
    public Usuario saveUsuario(String nombre, String nombreUsuario, String idChat) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if (usuario == null) {
            usuario = new Usuario(nombre, nombreUsuario, idChat);
            usuarioRepository.save(usuario);
        }
        return usuario;
    }

    // Método para guardar un mensaje en la base de datos
    public MensajeChat saveMensaje(Long usuarioId, String textoMensaje, Long temaId, Long conversacionId, String relevancia) {
        MensajeChat mensajeChat = new MensajeChat();
        
        // Busca entidades relacionadas
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        TemaMensaje tema = temaMensajeRepository.findById(temaId).orElse(null);
        Conversacion conversacion = conversacionRepository.findById(conversacionId).orElse(null);
        
        // Asigna valores y relaciones
        mensajeChat.setUsuario(usuario);
        mensajeChat.setTextoMensaje(textoMensaje);
        mensajeChat.setMarcaTiempo(LocalDateTime.now());
        mensajeChat.setTema(tema);
        mensajeChat.setConversacion(conversacion);
        mensajeChat.setRelevancia(Relevancia.valueOf(relevancia.toUpperCase()));
        
        mensajeChatRepository.save(mensajeChat);
        return mensajeChat;
    }

    // Método para crear una nueva conversación
    public Conversacion createConversacion() {
        Conversacion conversacion = new Conversacion();
        conversacionRepository.save(conversacion);
        return conversacion;
    }
}
