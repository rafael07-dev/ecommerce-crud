package com.rafael_dev.ecomerce.service;

import com.rafael_dev.ecomerce.exceptions.NotFoundCategory;
import com.rafael_dev.ecomerce.exceptions.NotFoundProduct;
import com.rafael_dev.ecomerce.mapper.ProductMapper;
import com.rafael_dev.ecomerce.repository.CategoryRepository;
import com.rafael_dev.ecomerce.repository.ProductRepository;
import com.rafael_dev.ecomerce.dto.producto.ProductDto;
import com.rafael_dev.ecomerce.model.Category;
import com.rafael_dev.ecomerce.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAllProducts(){
        return productMapper
                .toProductDtoList(productRepository.findAll());
    }

    public List<ProductDto> getProductByCategory(Long id){
        return productMapper
                .toProductDtoList(productRepository.findByCategoryId(id));
    }

    public ProductDto getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundProduct("Product not found"));

        return productMapper
                .toProductDto(product);
    }

    public ProductDto deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundProduct("Product not found id: " + id));

        productRepository.delete(product);

        return productMapper.toProductDto(product);
    }

    public ProductDto addProduct(ProductDto productDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());

        if(categoryOptional.isEmpty()) throw new NotFoundCategory("Category not found");

        Product product = productMapper.toProduct(productDto);
        product.setCategory(categoryOptional.get());

        productRepository.save(product);

        return productMapper.toProductDto(product);
    }

    public ProductDto updateProduct(ProductDto productDto, Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundProduct("Product not found id: " + id));

        Category categoryOptional = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new NotFoundCategory("Category not found"));

        product.setNameProduct(productDto.getNameProduct());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setCategory(categoryOptional);

        productRepository.save(product);

        return productMapper.toProductDto(product);
    }

}
