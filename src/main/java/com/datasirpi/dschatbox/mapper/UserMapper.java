package com.datasirpi.dschatbox.mapper;

import com.datasirpi.dschatbox.dto.User;
import com.datasirpi.dschatbox.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userID", target = "userId")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "password", target = "password")
    UserEntity userToUserEntity(User user);
}