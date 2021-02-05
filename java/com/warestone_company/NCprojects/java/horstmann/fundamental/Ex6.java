package com.warestone_company.NCprojects.java.horstmann.fundamental;

import java.math.BigInteger;

        /*Write a program that computes the factorial n! = 1 × 2 × . . . × n, using
        BigInteger. Compute the factorial of 1000.*/

public class Ex6 {

    public BigInteger computeFactorial(int fact){
        BigInteger result = BigInteger.valueOf(1);
        for (int i=1; i<=fact; i++)  result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
