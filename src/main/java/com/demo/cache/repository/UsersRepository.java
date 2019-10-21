package com.demo.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cache.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByName(String name);
}
