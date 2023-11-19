package com.rafael_dev.ecomerce.mapper;

import com.rafael_dev.ecomerce.dto.producto.ProductDto;
import com.rafael_dev.ecomerce.model.Category;
import com.rafael_dev.ecomerce.model.Product;
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
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setCategoryId( productCategoryId( product ) );
        productDto.setId( product.getId() );
        productDto.setNameProduct( product.getNameProduct() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setImageUrl( product.getImageUrl() );

        return productDto;
    }

    @Override
    public List<ProductDto> toProductDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( toProductDto( product ) );
        }

        return list;
    }

    @Override
    public Product toProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( productDtoToCategory( productDto ) );
        product.setId( productDto.getId() );
        product.setNameProduct( productDto.getNameProduct() );
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );
        product.setImageUrl( productDto.getImageUrl() );

        return product;
    }

    private Long productCategoryId(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Category productDtoToCategory(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( productDto.getCategoryId() );

        return category;
    }
}
