package com.rafael_dev.ecomerce.controller;

import com.rafael_dev.ecomerce.dto.producto.ProductDto;
import com.rafael_dev.ecomerce.service.ProductService;
import com.rafael_dev.ecomerce.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/id/{idProduct}")
    public ResponseEntity<ProductDto> getProductId(@PathVariable Long idProduct){
        return ResponseEntity.ok(productService.getProductById(idProduct));
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<List<ProductDto>> getProductCategory(@PathVariable Long idCategory){
        return ResponseEntity.ok(productService.getProductByCategory(idCategory));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto){
       return ResponseEntity.created(URI.create("/products/" + productDto.getId()))
               .body(productService.addProduct(productDto));
    }
    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable Long idProduct){

        return ResponseEntity.ok(productService.deleteProduct(idProduct));
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,
                                                     @PathVariable Long idProduct){
        return ResponseEntity.ok(productService.updateProduct(productDto , idProduct));
    }
}
