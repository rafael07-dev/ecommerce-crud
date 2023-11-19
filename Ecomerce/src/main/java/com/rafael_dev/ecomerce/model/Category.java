package com.rafael_dev.ecomerce.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_categoria")
    @NotEmpty
    private String nameCategory;

    @NotEmpty
    private String description;

    @NotEmpty
    private String imageUrl;

    public Category() {
    }

    public Category(Long id, String nameCategory, String description, String imageUrl) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
