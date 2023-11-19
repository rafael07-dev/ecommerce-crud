package com.rafael_dev.ecomerce.mapper;

import com.rafael_dev.ecomerce.dto.producto.ProductDto;
import com.rafael_dev.ecomerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "product.category.id", target = "categoryId")
    ProductDto toProductDto( Product product);

    List<ProductDto> toProductDtoList(List<Product> products);

    @Mapping(source = "productDto.categoryId", target = "category.id")
    Product toProduct(ProductDto productDto);

}
