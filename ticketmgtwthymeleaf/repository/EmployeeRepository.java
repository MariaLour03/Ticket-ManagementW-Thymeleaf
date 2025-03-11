package com.ticketmgtwthymeleaf.repository;

import com.ticketmgtwthymeleaf.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   Employee findByEmail(String email);

}
