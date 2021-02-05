package com.warestone_company.NCprojects.java.oop1;

import java.util.InputMismatchException;
import java.util.Objects;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle(double radius){
        setRadius(radius);
    }

    public Circle(double radius, String color){
        setRadius(radius);
        setColor(color);
    }

    public double getRadius(){
        return this.radius;
    }

    public String getColor(){
        return this.color;
    }

    public void setRadius(double radius){
        if (radius>0)this.radius=radius;
        else throw new InputMismatchException("Radius of circle must be above zero");
    }

    public void setColor(String color){
        if (color!=null)
        {
            if (!color.equals(""))this.color = color;
            else throw new InputMismatchException("Color of circle must don't be empty");
        }
        else throw new InputMismatchException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, this.radius) == 0 && Objects.equals(this.color, circle.color);
    }

    @Override
    public int hashCode() {
        final int hash = 7;
        final int multiplier = 3;
        return (hash * multiplier + Objects.hash(radius,color));
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + ", color='" + color + '\'' + '}';
    }

    public double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
}
