package com.warestone_company.NCprojects.java.horstmann.inheritanceAndReflection;

        /*4. Define an abstract class Shape with an instance variable of class Point, a
        constructor, a concrete method public void moveBy(double dx, double dy) that
        moves the point by the given amount, and an abstract method public Point
        getCenter(). Provide concrete subclasses Circle, Rectangle, Line with constructors
        public Circle(Point center, double radius), public Rectangle(Point topLeft, double width,
        double height), and public Line(Point from, Point to).

        5. Define clone methods for the classes of the preceding exercise.*/

public class Circle extends Shape implements Cloneable{
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point getCenter() { return center; }
    public double getRadius() { return radius; }

    public Circle clone(){ return new Circle(center,radius); }
}
