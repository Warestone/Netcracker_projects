package com.warestone_company.NCprojects.java.spring.lab_1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class AddUser implements Cloneable {

    @NotBlank(message = "Name not be empty!")
    @Size(min=2, max=50, message = "Name must have >=2 and <=50 characters!")
    @Pattern(regexp = "[A-Z][A-z]+[a-z]$", message = "Name must made up of letters, begin with a letter in upper case and ends with a letter in lower case!")
    private String lastName, firstName, patronymicName;

    @NotBlank(message = "Email not be empty!")
    @Pattern(regexp = "[a-z0-9\\.]{3,200}@[a-z0-9]{3,20}.?[a-z]{2,20}?", message = "Incorrect email address")
    private String email;

    @NotBlank(message = "  Work address not be empty!")
    @Pattern(regexp = "[A-z\\,\\.]+", message = "Address must made up of letters!")
    private String workAddress;

    @Min(value = 18, message = "Age must be greater than  18 and <=110!")
    @Max(value = 110, message = "Age must be less than 110 and >=18!")
    private short age;

    @Min(value = 1000, message = "Salary must be greater than 1000!")
    private double salary;

    public void clear(){
        workAddress = null;
        salary = 0.0;
        email = null;
        age = 0;
        patronymicName= null;
        lastName = null;
        firstName = null;
    }

    @Override
    public String toString() {
        return  lastName + '|' + firstName + '|' + patronymicName + '|' + email + '|' + workAddress + '|' +
                age + '|' + salary;
    }
}