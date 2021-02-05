package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;

import java.util.Arrays;
import java.util.InputMismatchException;

            /*1. Provide an interface Measurable with a method double getMeasure() that measures an object in some way. Make Employee implement Measurable. Provide
        a method double average(Measurable[] objects) that computes the average
        measure. Use it to compute the average salary of an array of employees.

              2. Continue with the preceding exercise and provide a method Measurable
        largest(Measurable[] objects). Use it to find the name of the employee with
        the largest salary*/

public class Employee implements Measurable{
    private double salary;
    private String name;

    @Override
    public double getMeasure() { return salary; }
    public String getName() { return name; }

    double average(Measurable[] objects){
        checkObjects(objects);
        int sumSalary = 0;
        for (Measurable object : objects) sumSalary+= object.getMeasure();
        return (double) sumSalary / Arrays.stream(objects).count();
    }

    public String largest(Measurable[] objects){
        checkObjects(objects);
        double maxSalary = 0;
        String name = "";
        for (Measurable object : objects){
            double salary = object.getMeasure();
            if (salary>maxSalary){
                name = object.getName();
                maxSalary = salary;
            }
        }
        return name;
    }

    private void checkObjects(Measurable[] objects){
        if (objects==null) throw new InputMismatchException("The input objects is null");
        if (Arrays.stream(objects).count()==0) throw new InputMismatchException("The input objects is empty");
    }
}
