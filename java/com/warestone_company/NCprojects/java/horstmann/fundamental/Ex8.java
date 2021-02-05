package com.warestone_company.NCprojects.java.horstmann.fundamental;

import java.util.InputMismatchException;

/*Write a program that reads a string and prints all of its nonempty substrings.*/

public class Ex8 {

    public void printAllNonEmptySubstrings(String string){
        if (string == null) throw new InputMismatchException("Null string");
        if (!string.equals("")){
            int length =  string.length();
            for (int i = 0; i < length; i++)
            {
                for(int f = 1; f <=  length - i; f++)
                {
                    String sub = string.substring(i, i+f);
                    if (!sub.replaceAll("\\s+","").equals("")) System.out.println(sub);
                }
            }
        }
    }
}
