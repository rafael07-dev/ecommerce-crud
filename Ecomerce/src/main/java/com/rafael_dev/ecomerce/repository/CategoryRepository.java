package com.rafael_dev.ecomerce.repository;

import com.rafael_dev.ecomerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Category findByNombre(String nombre);
}
