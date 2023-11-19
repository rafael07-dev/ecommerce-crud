package com.rafael_dev.ecomerce.mapper;

import com.rafael_dev.ecomerce.dto.categoria.CategoryDto;
import com.rafael_dev.ecomerce.model.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-18T21:47:39-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Microsoft)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setNameCategory( category.getNameCategory() );
        categoryDto.setDescription( category.getDescription() );
        categoryDto.setImageUrl( category.getImageUrl() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> toCategoryDtoList(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( toCategoryDto( category ) );
        }

        return list;
    }

    @Override
    public Category toCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setNameCategory( categoryDto.getNameCategory() );
        category.setDescription( categoryDto.getDescription() );
        category.setImageUrl( categoryDto.getImageUrl() );

        return category;
    }
}
