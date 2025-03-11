package com.ticketmgtwthymeleaf.repository;

import com.ticketmgtwthymeleaf.model.Employee;
import com.ticketmgtwthymeleaf.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByEmployee(Employee employee);
}
