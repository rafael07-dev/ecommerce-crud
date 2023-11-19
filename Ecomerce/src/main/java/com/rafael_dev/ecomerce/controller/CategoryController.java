package com.rafael_dev.ecomerce.controller;

import com.rafael_dev.ecomerce.dto.categoria.CategoryDto;
import com.rafael_dev.ecomerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.createCategory(categoryDto));
    }
    @PutMapping("/update/{idCategory}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("idCategory") Long categoryId, @Valid @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, categoryDto));
    }
    @DeleteMapping("/delete/{idCategory}")
    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable("idCategory") Long id){
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
}
