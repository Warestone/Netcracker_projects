package com.warestone_company.NCprojects.java.horstmann.inheritanceAndReflection;

        /*4. Define an abstract class Shape with an instance variable of class Point, a
        constructor, a concrete method public void moveBy(double dx, double dy) that
        moves the point by the given amount, and an abstract method public Point
        getCenter(). Provide concrete subclasses Circle, Rectangle, Line with constructors
        public Circle(Point center, double radius), public Rectangle(Point topLeft, double width,
        double height), and public Line(Point from, Point to).

        5. Define clone methods for the classes of the preceding exercise.*/

import java.util.InputMismatchException;

public class Rectangle extends Shape implements Cloneable{
    private double width, height;
    private Point topLeft;

    public Rectangle(double width, double height, Point topLeft) {
        super(topLeft);
        if (width<0 || height<0) throw new InputMismatchException("Width and height must be a positive values");
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
    }

    @Override
    public Point getCenter() { return new Point(topLeft.getX()+width/2,topLeft.getY()+height/2); }

    public Rectangle clone(){ return new Rectangle(width,height,topLeft); }
}
