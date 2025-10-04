package com.example.products_management.mapper;

import java.lang.annotation.Target;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.products_management.dto.request.UserCreationRequest;
import com.example.products_management.dto.request.UserUpdateRequest;
import com.example.products_management.dto.response.UserResponse;
import com.example.products_management.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request); 
    UserResponse toUserResponse(User user); 

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
