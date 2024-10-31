package com.example.main.repository;

import com.example.main.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = ?1 OR u.email = ?2")
    Optional<User> findByUsernameOrEmail(String username, String email);
}