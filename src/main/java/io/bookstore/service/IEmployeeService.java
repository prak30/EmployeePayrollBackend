package io.bookstore.service;

import java.util.List;
import java.util.Optional;

import io.bookstore.dto.EmployeeDTO;
import io.bookstore.model.Employee;



public interface IEmployeeService {
	Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getById(int id);

    String deleteById(int id);

    Employee editEmployee(EmployeeDTO employeeDtO, int id);
}
