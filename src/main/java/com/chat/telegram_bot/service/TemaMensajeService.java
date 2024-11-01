
package com.chat.telegram_bot.service; 
 
import com.chat.telegram_bot.model.TemaMensaje; 
import com.chat.telegram_bot.repository.TemaMensajeRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
import java.util.List; 
 
@Service 
public class TemaMensajeService { 
 
    @Autowired 
    private TemaMensajeRepository temaMensajeRepository; 
 
    // Agregar un nuevo tema 
    public TemaMensaje addTema(String nombreTema) { 
        TemaMensaje tema = new TemaMensaje(); 
        tema.setNombreTema(nombreTema); 
        return temaMensajeRepository.save(tema); 
    } 
 
    // Obtener todos los temas 
    public List<TemaMensaje> getAllTemas() { 
        return temaMensajeRepository.findAll(); 
    } 
}