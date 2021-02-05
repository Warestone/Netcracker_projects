package com.warestone_company.NCprojects.java.horstmann.fundamental;

        /*Using only the conditional operator, write a program that reads three
        integers and prints the largest. Repeat with Math.max.
        */

public class Ex3 {

    public void printMaxWithConditions(int value1, int value2, int value3){
        if (value1 > value2 && value1 > value3) print(value1);
        else if (value2 > value1 && value2 > value3) print(value2);
        else print(value3);
    }

    public void printMaxWithMath(int value1, int value2, int value3){
        print(Math.max(Math.max(value1,value2),value3));
    }

    private void print(int value){ System.out.println("The max value is: " + value); }
}
