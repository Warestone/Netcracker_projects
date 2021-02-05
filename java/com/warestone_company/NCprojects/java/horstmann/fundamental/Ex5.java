package com.warestone_company.NCprojects.java.horstmann.fundamental;

        /*What happens when you cast a double to an int that is larger than the
        largest possible int value? Try it out*/

public class Ex5 {

    public void tryCastDoubleToInt(){
        double value = 9147483647.0;
        int castValue = (int) value;
        System.out.println(castValue); // output max value of int
    }
}
