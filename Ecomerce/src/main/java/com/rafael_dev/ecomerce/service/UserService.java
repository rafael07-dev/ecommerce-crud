package com.rafael_dev.ecomerce.service;

import com.rafael_dev.ecomerce.dto.user.UserDto;
import com.rafael_dev.ecomerce.mapper.UserMapper;
import com.rafael_dev.ecomerce.model.UserEntity;
import com.rafael_dev.ecomerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto saveUser(UserDto userDtoRequest){
        UserEntity userEntity = userMapper.toUserEntity(userDtoRequest);

        /*Set<RoleEntity> roleEntities = new HashSet<>();

        for(String name : userDtoRequest.getRoles()){
            RoleEntity roleEntity = new RoleEntity();

            roleEntity.setName(ERole.valueOf(name));

            roleEntities.add(roleEntity);
        }

        userEntity.setRoles(roleEntities);*/

        userRepository.save(userEntity);

        return userMapper.toUserDto(userEntity);
    }
}
