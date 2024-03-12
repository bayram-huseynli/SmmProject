package com.example.smmproject.repository;

import com.example.smmproject.entity.ERole;
import com.example.smmproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
