package io.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.bookstore.dto.EmployeeDTO;
import io.bookstore.exception.CustomException;
import io.bookstore.model.Employee;
import io.bookstore.repository.EmployeeRepository;
@Service
public class EmployeeService implements IEmployeeService{
		
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		if (employeeRepository.findAll().isEmpty()) {
            throw new CustomException("No employee in database.");
        } else
            return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getById(int id) {
		  if (employeeRepository.findById(id).isPresent()) {
	            return employeeRepository.findById(id);
	        } else
	            throw new CustomException("No employee matches withemployee");
	}

	@Override
	public String deleteById(int id) {
		 if (employeeRepository.findById(id).isPresent()) {
	            employeeRepository.deleteById(id);
	            return "Employee with ID: " + id + " is Deleted Successfully!!";
	        } else
	            throw new CustomException("No employee matches with the given ID");
	}

	@Override
	public Employee editEmployee(EmployeeDTO employeeDtO, int id) {
		if (employeeRepository.findById(id).isPresent()) {
            Employee employee1 = new Employee(id, employeeDtO);
            return employeeRepository.save(employee1);

        } else
            throw new CustomException("No employee matches with the given ID");
	}

}
