package com.example.products_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.products_management.dto.request.UserCreationRequest;
import com.example.products_management.dto.request.UserUpdateRequest;
import com.example.products_management.entity.User;
import com.example.products_management.exception.AppException;
import com.example.products_management.exception.ErrorCode;
import com.example.products_management.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found."));
    }
    
    public User createUser(UserCreationRequest request) {
        User user = new User();

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        } 
        
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public User updatUser(String id, UserUpdateRequest request) {
        User user = getUser(id);
        
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        User user = getUser(id);

        userRepository.delete(user);
    }
}
