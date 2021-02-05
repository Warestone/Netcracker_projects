package com.warestone_company.NCprojects.java.horstmann.fundamental;

        /*Write a program that prints the smallest and largest positive double values.
        Hint: Look up Math.nextUp in the Java API.
        */

public class Ex4 {

    public void printValues(){
        System.out.println("Smallest positive double value: " + Math.nextUp(0));
        System.out.println("Largest positive double value: " + Math.nextUp(1));
    }
}
