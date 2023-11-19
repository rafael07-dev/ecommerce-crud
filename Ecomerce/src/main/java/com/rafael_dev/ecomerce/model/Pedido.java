package com.rafael_dev.ecomerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Date fechaHora;
    @NotEmpty
    private String estado;
    @ManyToOne
    private Usuario usuario;

    public Pedido(Long id, Date fechaHora, String estado, Usuario usuario) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
