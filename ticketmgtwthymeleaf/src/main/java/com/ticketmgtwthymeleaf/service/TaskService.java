package com.ticketmgtwthymeleaf.service;

import com.ticketmgtwthymeleaf.model.Employee;
import com.ticketmgtwthymeleaf.model.Task;
import com.ticketmgtwthymeleaf.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByEmployee(Employee employee){
        return taskRepository.findByEmployee(employee);
    }

    public Task updateTaskStatus(Long id, String status) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            task.get().setStatus(status);
            return taskRepository.save(task.get());
        }
        return null;
    }



}
