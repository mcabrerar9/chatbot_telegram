
package com.chat.telegram_bot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TemaMensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreTema;
}
