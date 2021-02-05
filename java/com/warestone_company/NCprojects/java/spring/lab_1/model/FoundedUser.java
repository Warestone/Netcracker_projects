package com.warestone_company.NCprojects.java.spring.lab_1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FoundedUser {
    private String lastName, firstName, patronymicName, email, workAddress;
    private short age;
    private double salary;

    public FoundedUser(String lastName, String firstName, String patronymicName, String email, String workAddress, short age, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.email = email;
        this.workAddress = workAddress;
        this.age = age;
        this.salary = salary;
    }
}
