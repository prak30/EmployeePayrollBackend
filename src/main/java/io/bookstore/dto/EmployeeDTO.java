package io.bookstore.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid: It should have at least 2 characters starting with Capital letter.")
    public String name;

    @NotEmpty(message = "Profile Pic cannot be null.")
    public String profilePic;

    @NotBlank
    public String gender;

    public List<String> department;

    public int salary;

    public LocalDate startDate;
    @NotEmpty
    public String notes;
}
