package dev.fullstack.employeemanager.controller;

import dev.fullstack.employeemanager.model.Employee;
import dev.fullstack.employeemanager.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        log.info("[?] EmployeeController.getAllEmployees");
        List<Employee> employees = this.employeeService.findAllEmployees();
        log.info("[<] EmployeeController.getAllEmployees, {}", employees);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        log.info("[?] EmployeeController.getEmployee");
        Employee employee = this.employeeService.findById(id);
        log.info("[<] EmployeeController.getEmployee, {}", employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        log.info("[>] EmployeeController.addEmployee");
        Employee newEmployee = this.employeeService.addEmployee(employee);
        log.info("[>] EmployeeController.addEmployee, {}", newEmployee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        log.trace("[>] EmployeeController.updateEmployee");
        Employee updateEmployee = this.employeeService.updateEmployee(employee);
        log.trace("[>] EmployeeController.addEmployee, {}   ", updateEmployee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        log.info("[x] EmployeeController.deleteEmployee {}", id);
        this.employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
