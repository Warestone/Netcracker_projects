package com.warestone_company.NCprojects.java.horstmann.object;

import java.util.InputMismatchException;

        /*Implement a class Car that models a car traveling along the x-axis, consuming gas as it moves. Provide methods to drive by a given number of
        miles, to add a given number of gallons to the gas tank, and to get the
        current distance from the origin and fuel level. Specify the fuel efficiency
        (in miles/gallons) in the constructor. Should this be an immutable class?
        Why or why not?
        */

        // This class must be mutable, because there are many different cars with their own parameters.

public class Car {
    private int miles, x;
    private double gallons, gallonsPerMile;

    public Car(int gallonsPerMile){
        if (gallonsPerMile<=0) throw new InputMismatchException("Fuel consumption value must be greater than zero");
        this.gallonsPerMile = gallonsPerMile;
    }

    public int getMiles() { return miles; }
    public double getGallons() { return gallons; }
    public double getGallonsPerMile() { return gallonsPerMile; }

    public void moveCar(int upMiles){
        while (gallonsPerMile<=gallons){
            if (upMiles<=0)break;
            x+=100;
            miles++;
            upMiles--;
            gallons-=gallonsPerMile;
        }
    }

    public void increaseGallons(int addGallons){
        if (addGallons<0) throw new InputMismatchException("Gallons must be positive value!");
        gallons+=addGallons;
    }
}
