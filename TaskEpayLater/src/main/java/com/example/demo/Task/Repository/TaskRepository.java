package com.example.demo.Task.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Task.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
