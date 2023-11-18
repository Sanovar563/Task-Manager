package com.Taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Taskmanager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
