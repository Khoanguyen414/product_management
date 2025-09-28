package com.example.products_management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.products_management.dto.request.RoleRequest;
import com.example.products_management.dto.response.RoleResponse;
import com.example.products_management.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
} 
