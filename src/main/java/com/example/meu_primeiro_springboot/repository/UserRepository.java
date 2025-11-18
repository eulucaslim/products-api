package com.example.meu_primeiro_springboot.repository;

import com.example.meu_primeiro_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String name);
}
