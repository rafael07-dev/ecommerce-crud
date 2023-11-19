package com.rafael_dev.ecomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String informacionAdicional;

    public MetodoPago(Long id, String nombre, String informacionAdicional) {
        this.id = id;
        this.nombre = nombre;
        this.informacionAdicional = informacionAdicional;
    }

    public MetodoPago() {
    }

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

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }
}
