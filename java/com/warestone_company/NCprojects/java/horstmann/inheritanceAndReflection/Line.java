package com.warestone_company.NCprojects.java.horstmann.inheritanceAndReflection;

        /*4. Define an abstract class Shape with an instance variable of class Point, a
        constructor, a concrete method public void moveBy(double dx, double dy) that
        moves the point by the given amount, and an abstract method public Point
        getCenter(). Provide concrete subclasses Circle, Rectangle, Line with constructors
        public Circle(Point center, double radius), public Rectangle(Point topLeft, double width,
        double height), and public Line(Point from, Point to).

        5. Define clone methods for the classes of the preceding exercise.*/

public class Line extends Shape implements Cloneable{
    private Point from,to;

    public Line(Point from, Point to) {
        super(from);
        this.from = from;
        this.to = to;
    }

    @Override
    public Point getCenter() { return new Point(to.getX()-from.getX()/2, to.getY()-from.getY()/2); }

    public Line clone(){ return new Line(from,to); }
}
