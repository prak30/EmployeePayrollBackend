package io.bookstore.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import io.bookstore.dto.EmployeeDTO;
import lombok.Data;


@Entity
@Data
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String profilePic;
    public String gender;
    @ElementCollection
    @CollectionTable(name = "department", joinColumns = @JoinColumn(name = "id"))
    public List<String> department;
    public int salary;

    public LocalDate startDate;
    public String notes;

    public Employee() {

    }

    public Employee(int id, EmployeeDTO employeeDTO) {
        this.id = id;
        this.name = employeeDTO.name;
        this.profilePic = employeeDTO.profilePic;
        this.gender = employeeDTO.gender;
        this.department = employeeDTO.department;

        this.notes = employeeDTO.notes;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.startDate;
    }

    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.name;
        this.profilePic = employeeDTO.profilePic;
        this.gender = employeeDTO.gender;
        this.department = employeeDTO.department;

        this.notes = employeeDTO.notes;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.startDate;
    }
}
