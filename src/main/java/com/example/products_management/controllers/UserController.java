package com.example.products_management.controllers;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import com.example.products_management.dto.request.UserCreationRequest;
import com.example.products_management.dto.request.UserUpdateRequest;
import com.example.products_management.dto.response.ApiResponse;
import com.example.products_management.dto.response.UserResponse;
import com.example.products_management.service.UserService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    @GetMapping
    ApiResponse<List<UserResponse>> getAllUsers() {
        var authenication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Username: {}", authenication.getName());
        authenication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
            .result(userService.getAllUsers())
            .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
        return ApiResponse.<UserResponse>builder()
            .result(userService.getUser(userId))
            .build();
    }

     @GetMapping("/my_profile")
    ApiResponse<UserResponse> getMyProfile() {
        return ApiResponse.<UserResponse>builder()
            .result(userService.getMyProfile())
            .build();
    }

    @PostMapping
    ApiResponse<UserResponse> creatUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    void deletUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
    }
    
}
