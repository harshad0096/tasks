package com.example.demo.Task.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Task.Repository.TaskRepository;
import com.example.demo.Task.model.Task;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
//methode for api used in controller class
    public Task createTask(Task task) {
       
        // Save the task in the database
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        // Retrieve the task by its ID from the database
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.orElse(null);
    }

    public List<Task> getAllTasks() {
        // Retrieve all tasks from the database
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task updatedTask) {
        // Retrieve the existing task from the database by its ID
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task existingTask = taskOptional.get();

            // Update the task properties with the new values
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());

            // Save the updated task in the database
            return taskRepository.save(existingTask);
        } else {
            return null; // Return null if the task with the given ID does not exist
        }
    }

    public boolean deleteTask(Long id) {
        // Delete the task from the database
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            taskRepository.deleteById(id);
            return true; // Return true if the task was deleted successfully
        } else {
            return false; // Return false if the task with the given ID does not exist
        }
    }
}
