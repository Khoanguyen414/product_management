package com.example.products_management.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.products_management.dto.request.AuthenticationRequest;
import com.example.products_management.dto.request.IntrospectRequest;
import com.example.products_management.dto.response.ApiResponse;
import com.example.products_management.dto.response.AuthenticationResponse;
import com.example.products_management.dto.response.IntrospectResponse;
import com.example.products_management.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenicate(request);
        return ApiResponse.<AuthenticationResponse>builder()
            .result(result)
            .build();
    }
    
    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) 
            throws JOSEException, ParseException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
            .result(result)
            .build();
    }
}
