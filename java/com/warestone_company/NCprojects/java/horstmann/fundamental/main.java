package com.warestone_company.NCprojects.java.horstmann.fundamental;

import com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda.Ex3;
import com.warestone_company.NCprojects.java.horstmann.object.*;

public class main {
    public static void main(String[] args) {

        new Ex3().printSupertypes();
        new Ex10().printGeneratedStringInBase36(10);

        System.out.println("Is magic square? "+ (new Ex14().checkMagicSquare()?"Yes!":"No!"));

        Point point = new Point(3,4);
        point.translate(1,3);
        point.scale(0.5);
        System.out.println("x: "+point.getX()+"\ny: "+point.getY());

        Car car = new Car(5);
        car.increaseGallons(5);
        car.moveCar(2);
        System.out.println("Car miles: "+car.getMiles()+"\nCar gallons: "+car.getGallons());
    }
}
