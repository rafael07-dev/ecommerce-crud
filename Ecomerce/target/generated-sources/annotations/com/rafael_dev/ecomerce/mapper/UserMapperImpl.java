package com.rafael_dev.ecomerce.mapper;

import com.rafael_dev.ecomerce.dto.user.UserDto;
import com.rafael_dev.ecomerce.model.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-18T22:05:17-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Microsoft)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setRoles( UserMapper.toSetString( userEntity.getRoles() ) );
        userDto.setId( userEntity.getId() );
        userDto.setEmail( userEntity.getEmail() );
        userDto.setUsername( userEntity.getUsername() );
        userDto.setPassword( userEntity.getPassword() );

        return userDto;
    }

    @Override
    public UserEntity toUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setRoles( UserMapper.toSetRoleEntity( userDto.getRoles() ) );
        userEntity.setId( userDto.getId() );
        userEntity.setEmail( userDto.getEmail() );
        userEntity.setUsername( userDto.getUsername() );
        userEntity.setPassword( userDto.getPassword() );

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
