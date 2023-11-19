package com.rafael_dev.ecomerce.dto.producto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductDto {
    private Long id;

    @NotEmpty
    private String nameProduct;

    @NotEmpty
    private String description;

    @NotNull
    private double price;

    @NotEmpty
    private String imageUrl;

    @NotNull
    private Long categoryId;

    public ProductDto() {
    }

    public ProductDto(Long id, String nameProduct, String description, double price, String imageUrl, Long categoryId) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
