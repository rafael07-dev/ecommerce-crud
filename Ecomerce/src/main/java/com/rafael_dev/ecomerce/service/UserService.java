package com.rafael_dev.ecomerce.service;

import com.rafael_dev.ecomerce.dto.user.UserDto;
import com.rafael_dev.ecomerce.mapper.UserMapper;
import com.rafael_dev.ecomerce.model.UserEntity;
import com.rafael_dev.ecomerce.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto saveUser(UserDto userDtoRequest){
        UserEntity userEntity = userMapper.toUserEntity(userDtoRequest);

        userRepository.save(userEntity);

        return userMapper.toUserDto(userEntity);
    }

    public UserDto updateUser(Long id, UserDto userDtoRequest){
        UserEntity userEntityRequest = userMapper.toUserEntity(userDtoRequest);

        Optional<UserEntity> userEntityOptional = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));

        if(userEntityOptional.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        UserEntity userEntity = userEntityOptional.get();

        userEntity.setEmail(userEntityRequest.getEmail());
        userEntity.setPassword(userEntityRequest.getPassword());
        userEntity.setRoles(userEntityRequest.getRoles());
        userRepository.save(userEntity);

        return userMapper.toUserDto(userEntity);
    }
/*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        userEntity.getRoles()
                .forEach(role -> {
                    grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
                });

        userEntity.getRoles().stream()
                .flatMap(role -> role.getPermissionsList().stream())
                .forEach(permission -> grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                grantedAuthorities);
    }*/

}
