package com.warestone_company.NCprojects.java.horstmann.fundamental;

import java.util.InputMismatchException;

        /*Write a program that reads an integer and prints it in binary, octal, and
        hexadecimal. Print the reciprocal as a hexadecimal floating-point number.*/

public class Ex1 {
    private int value;

    public Ex1 (int value)
    { setValue(value); }

    public void setValue(int value) { this.value = value; }

    public int getValue() { return value; }

    public void printBinary() { System.out.println(value + "to binary: "+Integer.toBinaryString(value)); }

    public void printOctal() { System.out.println(value + "to octal: "+Integer.toOctalString(value)); }

    public void printHexadecimal() { System.out.println(value + "to hexadecimal: "+Integer.toHexString(value)); }

    public void printReverseInHex() {
        if (value==0) throw new InputMismatchException("Division by zero.");
        else System.out.println(value + "to hexadecimal: "+Float.toHexString(1.0f/value)); }
}
