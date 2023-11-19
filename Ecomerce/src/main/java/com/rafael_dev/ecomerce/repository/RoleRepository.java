package com.rafael_dev.ecomerce.repository;

import com.rafael_dev.ecomerce.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
