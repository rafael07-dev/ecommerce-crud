package com.rafael_dev.ecomerce.mapper;

import com.rafael_dev.ecomerce.dto.user.UserDto;
import com.rafael_dev.ecomerce.model.RoleEntity;
import com.rafael_dev.ecomerce.model.UserEntity;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-05T12:05:03-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( userEntity.getId() );
        userDto.setEmail( userEntity.getEmail() );
        userDto.setUsername( userEntity.getUsername() );
        userDto.setPassword( userEntity.getPassword() );
        userDto.setUserCreateDate( userEntity.getUserCreateDate() );
        userDto.setNotificationPermission( userEntity.isNotificationPermission() );
        Set<RoleEntity> set = userEntity.getRoles();
        if ( set != null ) {
            userDto.setRoles( new LinkedHashSet<RoleEntity>( set ) );
        }

        return userDto;
    }

    @Override
    public UserEntity toUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDto.getId() );
        userEntity.setEmail( userDto.getEmail() );
        userEntity.setUsername( userDto.getUsername() );
        userEntity.setPassword( userDto.getPassword() );
        Set<RoleEntity> set = userDto.getRoles();
        if ( set != null ) {
            userEntity.setRoles( new LinkedHashSet<RoleEntity>( set ) );
        }
        userEntity.setUserCreateDate( userDto.getUserCreateDate() );
        userEntity.setNotificationPermission( userDto.isNotificationPermission() );

        return userEntity;
    }

    @Override
    public List<UserDto> toListUserDto(List<UserEntity> userEntities) {
        if ( userEntities == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userEntities.size() );
        for ( UserEntity userEntity : userEntities ) {
            list.add( toUserDto( userEntity ) );
        }

        return list;
    }
}
