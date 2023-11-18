package com.Taskmanager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Taskmanager.entity.Task;

import com.Taskmanager.repository.TaskRepository;
import com.Taskmanager.repository.UserRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

//    @Autowired private UserRepository userRepository;
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public Task createTask(Task task) {
        task.setDueDate(new Date()); // Set the default due date if not provided
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task updatedTask) {
        Optional<Task> existingTask = taskRepository.findById(taskId);

        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
//            task.setAssignedUser(updatedTask.getAssignedUser()); 
            task.setDueDate(updatedTask.getDueDate());
            task.setPriority(updatedTask.getPriority());
            // ... update other fields as needed

            return taskRepository.save(task);
        } else {
            return null;
        }
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

//    @Transactional
//    public Task addTask(Task task, Long userId) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
//
//        // Associate the task with the user
//        task.setAssignedUser(user);
//
//        // Save or merge the task
//        return taskRepository.save(task);
//    }
    
    
    
}