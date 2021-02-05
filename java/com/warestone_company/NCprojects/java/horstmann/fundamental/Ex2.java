package com.warestone_company.NCprojects.java.horstmann.fundamental;

import java.util.InputMismatchException;

        /*Write a program that reads an integer angle (which may be positive or
        negative) and normalizes it to a value between 0 and 359 degrees. Try
        it first with the % operator, then with floorMod.*/

public class Ex2 {
    private int angle;

    public Ex2 (int angle)
    { setAngle(angle); }

    public void setAngle(int angle) {
        if (angle > 180 || angle < -180) throw new InputMismatchException("The angle may be between -180 & 180!");
        else this.angle = angle;
    }

    public int getAngle() { return angle; }

    public void getRadians(){ System.out.println("Angle: " + angle + " in radians: " + angle%360);}
    public void getRadiansFloorMod(){ System.out.println("Angle: " + angle + " in radians: " + Math.floorMod(angle,360));}
}
