package com.warestone_company.NCprojects.java.horstmann.fundamental;

import java.util.InputMismatchException;

        /*Write a program that reads in two integers between 0 and 4294967295,
        stores them in int variables, and computes and displays their unsigned
        sum, difference, product, quotient, and remainder. Do not convert them
        to long values.*/

public class Ex7 {
    private int firstValue, secondValue;

    public Ex7(int firstValue, int secondValue){
        if (firstValue > 0 || secondValue > 0 ){  //4294967295 - overflows int datatype. 2147483647 is MAX
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }
        else throw new InputMismatchException("Values must be greater than zero.");
    }

    public int getSum(){ return firstValue + secondValue; }

    public int getDifference(){ return Math.abs(firstValue-secondValue); }

    public int getProduct() { return firstValue * secondValue; }

    public int getQuotient() { return firstValue/secondValue; }

    public int getRemainder() { return  firstValue%secondValue; }
}
