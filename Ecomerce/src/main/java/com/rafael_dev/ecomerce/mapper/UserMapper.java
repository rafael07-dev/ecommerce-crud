package com.rafael_dev.ecomerce.mapper;

import com.rafael_dev.ecomerce.dto.user.UserDto;
import com.rafael_dev.ecomerce.model.UserEntity;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(UserEntity userEntity);

    UserEntity toUserEntity(UserDto userDto);

    List<UserDto> toListUserDto(List<UserEntity> userEntities);
/*
    @Named("toSetRoleEntity")
    static Set<RoleEntity> toSetRoleEntity(Set<String> roles){
        return roles.stream()
                .map(roleName -> {
                    RoleEntity roleEntity = new RoleEntity();
                    roleEntity.setName(ERole.valueOf(roleName));
                    return roleEntity;
                }).collect(Collectors.toSet());
    }

    @Named("toSetString")
    static Set<String> toSetString(Set<RoleEntity> roles){
        return roles.stream()
                .map(role -> role.getName() != null ? role.getName() : null)
                .collect(Collectors.toSet());
    }

    @Named("toSetRoleString")
    static Set<String> toSetRoleString(Set<RoleEntity> roles){
        return roles.stream()
                        .map(roleEntity -> roleEntity.getName() != null ? roleEntity.getName() : null)
                                .collect(Collectors.toSet());
    }*/

}