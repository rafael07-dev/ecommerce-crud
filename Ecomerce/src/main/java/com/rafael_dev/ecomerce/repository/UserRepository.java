package com.rafael_dev.ecomerce.repository;

import com.rafael_dev.ecomerce.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select u from UserEntity u where u.username = ?1")
    Optional<UserEntity> findByUsername(String username);
}
