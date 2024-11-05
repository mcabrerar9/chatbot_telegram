
package com.chat.telegram_bot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;    
    private String nombreUsuario;
    private String idChat;

    // Constructor vacío requerido por JPA
    public Usuario() {
    }
      
    // Constructor sin el campo 'id'
    public Usuario(String nombre, String nombreUsuario, String idChat) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.idChat = idChat;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }
}
