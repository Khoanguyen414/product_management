package com.example.products_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.products_management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    boolean existsByUsername(String userName);
}  
