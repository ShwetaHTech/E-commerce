package com.ecommerce.Repository;

import com.ecommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for User table
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom method to find user by email and password
    User findByEmailAndPassword(String email, String password);
}
