package com.rafael_dev.ecomerce.service;

import com.rafael_dev.ecomerce.dto.categoria.CategoryDto;
import com.rafael_dev.ecomerce.exceptions.CategoryExistException;
import com.rafael_dev.ecomerce.exceptions.NotFoundCategory;
import com.rafael_dev.ecomerce.mapper.CategoryMapper;
import com.rafael_dev.ecomerce.repository.CategoryRepository;
import com.rafael_dev.ecomerce.model.Category;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDto> getAllCategory(){
        return categoryMapper.toCategoryDtoList(categoryRepository.findAll());
    }

    public CategoryDto createCategory(CategoryDto categoryDto){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryDto.getId());

        if(categoryOptional.isPresent())
            throw new CategoryExistException("Category exists");

        Category category = categoryMapper.toCategory(categoryDto);

        categoryRepository.save(category);

        return categoryMapper.toCategoryDto(category);
    }

    public CategoryDto updateCategory(Long idCategory, CategoryDto categoryDto){

        Category categoryOptional = categoryRepository.findById(idCategory)
                .orElseThrow(() -> new NotFoundCategory("Category not found"));

        categoryOptional.setNameCategory(categoryDto.getNameCategory());
        categoryOptional.setDescription(categoryDto.getDescription());
        categoryOptional.setImageUrl(categoryDto.getImageUrl());

        categoryRepository.save(categoryOptional);

        return categoryMapper.toCategoryDto(categoryOptional);
    }

    public CategoryDto deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundCategory("Category not found"));

        categoryRepository.delete(category);

        return categoryMapper.toCategoryDto(category);
    }
}
