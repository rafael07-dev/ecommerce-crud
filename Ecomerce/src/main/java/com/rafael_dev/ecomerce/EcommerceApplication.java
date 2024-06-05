package com.rafael_dev.ecomerce;

import com.rafael_dev.ecomerce.model.PermissionEntity;
import com.rafael_dev.ecomerce.model.RoleEntity;
import com.rafael_dev.ecomerce.model.UserEntity;
import com.rafael_dev.ecomerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner init (UserRepository userRepository) {
        return args -> {
            /* Create PERMISSIONS */
            PermissionEntity createPermission = new PermissionEntity("CREATE", "Puede Crear");

            PermissionEntity readPermission = new PermissionEntity("READ", "Puede leer");

            PermissionEntity updatePermission = new PermissionEntity("UPDATE", "Puede actualizar");

            PermissionEntity deletePermission = new PermissionEntity("DELETE", "Puede eliminar");

            PermissionEntity refactorPermission = new PermissionEntity("REFACTOR", "Puede refactorizar");

            /* Create ROLES */
            RoleEntity roleAdmin = new RoleEntity(
                    "ADMIN",
                    Set.of(createPermission, readPermission, updatePermission,
                            deletePermission, refactorPermission)
            );

            RoleEntity roleUser = new RoleEntity(
                    "USER",
                    Set.of(createPermission, readPermission)
            );

            RoleEntity roleInvited = new RoleEntity(
                    "INVITED",
                    Set.of(readPermission)
            );

            /* CREATE USERS */
            UserEntity userSantiago = new UserEntity(
                    "santiago@email.com",
                    "Santiago",
                    "$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6",
                    Set.of(roleAdmin),
                    new Date(),
                    true
            );

            UserEntity userDaniel = new UserEntity(
                    "daniel@email.com",
                    "Daniel",
                    "$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6",
                    Set.of(roleInvited),
                    new Date(),
                    true
            );

            UserEntity userAndrea = new UserEntity(
                    "andrea@email.com",
                    "Andrea",
                    "$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6",
                    Set.of(roleInvited),
                    new Date(),
                    true
            );

            userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea));
        };
    }
}
