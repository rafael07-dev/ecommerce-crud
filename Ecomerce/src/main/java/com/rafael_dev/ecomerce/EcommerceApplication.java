package com.rafael_dev.ecomerce;

import com.rafael_dev.ecomerce.dto.categoria.CategoryDto;
import com.rafael_dev.ecomerce.dto.producto.ProductDto;
import com.rafael_dev.ecomerce.service.CategoryService;
import com.rafael_dev.ecomerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner (CategoryService categoryService,
                                     ProductService productService){
        return args -> {

            categoryService.createCategory(new CategoryDto(
                    1L,
                    "Electrodomesticos",
                    "Los mejores electrodomesticos del mercado",
                    "www.img.org"));

            productService.addProduct(new ProductDto(
                    1L,
                    "Tv samsung",
                    "El mejor tv de samgung",
                    8000000.0,
                    "www.tv.org",
                    1L));
        };

    }

}
