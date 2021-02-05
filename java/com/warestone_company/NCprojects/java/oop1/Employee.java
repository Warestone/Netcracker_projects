package com.warestone_company.NCprojects.java.oop1;

import java.util.InputMismatchException;
import java.util.Objects;

public class Employee {

    private int id,salary;
    private String firstName, lastName;

    public Employee(int id, String firstName, String lastName, int salary){
        if (id<0) throw new InputMismatchException("ID must be above zero");
        if (firstName == null || lastName == null) throw new InputMismatchException("Firstname & lastname is required");
        setSalary(salary);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getName(){
        return firstName+' '+lastName;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        if (salary>0) this.salary = salary;
        else throw new InputMismatchException("Salary must be above zero (Nice joke over workman)");
    }

    public int getAnnualSalary(){
        return salary*12;
    }

    public int raiseSalary(int percent){
        return salary += (salary/100)*percent;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", salary=" + salary + ", name='" + firstName + ' ' + lastName + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.id == employee.id && this.salary == employee.salary && Objects.equals(this.firstName, employee.firstName) && Objects.equals(this.lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        final int hash = 8;
        final int multiplier = 2;
        return (hash * multiplier + Objects.hash(firstName, lastName) + id + salary);
    }
}
