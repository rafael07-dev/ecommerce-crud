package com.rafael_dev.ecomerce.dto.categoria;

import jakarta.validation.constraints.NotEmpty;

public class CategoryDto {

    private Long id;

    @NotEmpty
    private String nameCategory;

    @NotEmpty
    private String description;

    @NotEmpty
    private String imageUrl;

    public CategoryDto() {
    }

    public CategoryDto(Long id, String nameCategory, String description, String imageUrl) {
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
