package com.Taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Taskmanager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
