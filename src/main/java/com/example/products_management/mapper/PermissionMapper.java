package com.example.products_management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.products_management.dto.request.PermissionRequest;
import com.example.products_management.dto.response.PermissionResponse;
import com.example.products_management.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
    void updatePermission(@MappingTarget Permission permission, PermissionRequest request);   
} 
