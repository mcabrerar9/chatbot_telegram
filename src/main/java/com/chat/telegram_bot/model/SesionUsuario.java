
package com.chat.telegram_bot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sesion_usuario")
public class SesionUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime inicio;
    private LocalDateTime fin;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
