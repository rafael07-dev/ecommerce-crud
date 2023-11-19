package com.rafael_dev.ecomerce.mapper;

import com.rafael_dev.ecomerce.dto.user.UserDto;
import com.rafael_dev.ecomerce.model.ERole;
import com.rafael_dev.ecomerce.model.RoleEntity;
import com.rafael_dev.ecomerce.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles",source = "roles",  qualifiedByName = "toSetString")
    UserDto toUserDto(UserEntity userEntity);

    @Mapping(target = "roles", source = "roles", qualifiedByName = "toSetRoleEntity")
    UserEntity toUserEntity(UserDto userDto);

    List<UserDto> toListUserDto(List<UserEntity> userEntities);

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
                .map(role -> role.getName() != null ? role.getName().name() : null)
                .collect(Collectors.toSet());
    }

}