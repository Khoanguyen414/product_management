    package com.example.products_management.dto.request;

    import java.time.LocalDate;

import com.example.products_management.validator.DobConstraint;

import jakarta.validation.constraints.Size;
    import lombok.AccessLevel;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import lombok.experimental.FieldDefaults;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Builder
    public class UserCreationRequest {
        @Size(min = 3, message = "USERNAME_INVALID")
        String username;

        @Size(min = 8, message = "PASSWORD_INVALID")
        String password;
        String firstName;
        String lastName;

        @DobConstraint(min = 16, message = "INVALID_DOB")
        LocalDate dob;
    }
