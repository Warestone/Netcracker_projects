package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;

public interface Measurable {

            /*1. Provide an interface Measurable with a method double getMeasure() that measures an object in some way. Make Employee implement Measurable. Provide
        a method double average(Measurable[] objects) that computes the average
        measure. Use it to compute the average salary of an array of employees.

              2. Continue with the preceding exercise and provide a method Measurable
        largest(Measurable[] objects). Use it to find the name of the employee with
        the largest salary*/

    public double getMeasure();
    public String getName();
}
