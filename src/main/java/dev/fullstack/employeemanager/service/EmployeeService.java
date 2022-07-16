package dev.fullstack.employeemanager.service;

import dev.fullstack.employeemanager.exception.UserNotFoundException;
import dev.fullstack.employeemanager.model.Employee;
import dev.fullstack.employeemanager.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return this.employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepo.save(employee);
    }

    public Employee findById(Long id){
        return this.employeeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id: " + id + " was net found."));
    }

    public  void deleteEmployeeById(Long id){
        this.employeeRepo.deleteEmployeeById(id);
    }
}
