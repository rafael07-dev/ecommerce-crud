package com.rafael_dev.ecomerce.mapper;

import com.rafael_dev.ecomerce.dto.categoria.CategoryDto;
import com.rafael_dev.ecomerce.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toCategoryDto(Category category);

    List<CategoryDto> toCategoryDtoList(List<Category> categoryList);

    Category toCategory(CategoryDto categoryDto);
}
