package com.rafael_dev.ecomerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nameProduct;

    @NotEmpty
    private String description;

    @NotNull
    private double price;

    @NotEmpty
    private String imageUrl;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category category;

    public Product() {
    }

    public Product(Long id, String nameProduct, String description, double price, String imageUrl, Category category) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
