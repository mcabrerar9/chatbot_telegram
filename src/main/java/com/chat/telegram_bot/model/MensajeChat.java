
package com.chat.telegram_bot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "mensaje_chat")
public class MensajeChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String textoMensaje;
    private LocalDateTime marcaTiempo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_tema")
    private TemaMensaje tema;

    @ManyToOne
    @JoinColumn(name = "id_conversacion")
    private Conversacion conversacion;

    @Enumerated(EnumType.STRING)
    private Relevancia relevancia;
}
