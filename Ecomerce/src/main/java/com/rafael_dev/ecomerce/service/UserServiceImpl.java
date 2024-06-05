package com.rafael_dev.ecomerce.service;

import com.rafael_dev.ecomerce.dto.user.UserDto;
import com.rafael_dev.ecomerce.mapper.UserMapper;
import com.rafael_dev.ecomerce.model.RoleEntity;
import com.rafael_dev.ecomerce.model.UserEntity;
import com.rafael_dev.ecomerce.repository.RoleRepository;
import com.rafael_dev.ecomerce.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto saveUser(UserDto userDtoRequest){
        UserEntity userEntity = userMapper.toUserEntity(userDtoRequest);
        Set<RoleEntity> roles = new HashSet<>();
        Optional<RoleEntity> optionalRoleUSer = roleRepository.findByName("ROLE_USER");

        optionalRoleUSer.ifPresent(roles::add);

        if(userDtoRequest.isAdmin()){
            Optional<RoleEntity> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");

            optionalRoleAdmin.ifPresent(roles::add);
        }
        userEntity.setRoles(roles);
        userEntity.setPassword(passwordEncoder.encode(userDtoRequest.getPassword()));

        userRepository.save(userEntity);

        return userMapper.toUserDto(userEntity);
    }
}
