package com.rafael_dev.ecomerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ComentarioValoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Product product;
    @NotEmpty
    private String texto;
    @NotEmpty
    private int calificacion;

    public ComentarioValoracion(Long id, Usuario usuario, Product product, String texto, int calificacion) {
        this.id = id;
        this.usuario = usuario;
        this.product = product;
        this.texto = texto;
        this.calificacion = calificacion;
    }

    public ComentarioValoracion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Product getProducto() {
        return product;
    }

    public void setProducto(Product product) {
        this.product = product;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
