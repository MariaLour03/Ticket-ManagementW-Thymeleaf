package com.ticketmgtwthymeleaf.controller;

import com.ticketmgtwthymeleaf.model.Employee;
import com.ticketmgtwthymeleaf.model.Task;
import com.ticketmgtwthymeleaf.service.EmployeeService;
import com.ticketmgtwthymeleaf.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final EmployeeService employeeService;

    public TaskController(TaskService taskService, EmployeeService employeeService) {
        this.taskService = taskService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @GetMapping("/new")
    public String showCreateTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Optional<Task> task = taskService.getTaskById(id);
        model.addAttribute("task", task.get());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "task-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

//    @GetMapping("/employee")
//    public String employeeTaskHub(Model model) {
//
//        Employee employee = getAuthenticatedEmployee();
//        List<Task> tasks = taskService.getTasksByEmployee(employee);
//        model.addAttribute("tasks", tasks);
//        return "task-hub";
//    }



}
