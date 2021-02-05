package com.warestone_company.NCprojects.java.horstmann.inheritanceAndReflection;

        /*7. Define an enumeration type for the eight combinations of primary colors
        BLACK, RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE with methods getRed, getGreen,
        and getBlue.
        */

public enum Colors {
    BLACK,
    RED,
    BLUE,
    GREEN,
    CYAN,
    MAGENTA,
    YELLOW,
    WHITE;

    public Colors getRed(){ return Colors.RED; }
    public Colors getGreen(){ return Colors.GREEN; }
    public Colors getBlue(){ return Colors.BLUE; }
}
