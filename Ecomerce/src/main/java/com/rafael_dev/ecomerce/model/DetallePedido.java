package com.rafael_dev.ecomerce.model;

import jakarta.persistence.*;

@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Product product;
    private int cantidad;
    private int precioUnitario;
    private int total;

    public DetallePedido(Long id, Pedido pedido, Product product, int cantidad, int precioUnitario, int total) {
        this.id = id;
        this.pedido = pedido;
        this.product = product;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = total;
    }

    public DetallePedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Product getProducto() {
        return product;
    }

    public void setProducto(Product product) {
        this.product = product;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
        calcularTotal();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public void calcularTotal() {
        this.total = cantidad * precioUnitario;
    }
}
