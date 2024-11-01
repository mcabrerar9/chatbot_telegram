
package com.chat.telegram_bot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RespuestaBot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String textoRespuesta;

    @ManyToOne
    @JoinColumn(name = "id_mensaje_chat")
    private MensajeChat mensajeChat;
}
