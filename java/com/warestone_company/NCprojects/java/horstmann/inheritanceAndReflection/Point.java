package com.warestone_company.NCprojects.java.horstmann.inheritanceAndReflection;

        /*1 Define a class Point with a constructor public Point(double x, double y) and
        accessor methods getX, getY. Define a subclass LabeledPoint with a constructor
        public LabeledPoint(String label, double x, double y) and an accessor method
        getLabel.*/

        /*2 Define toString, equals, and hashCode methods for the classes of the preceding
        exercise*/

        /*3 Make the instance variables x and y of the Point class in Exercise 1 protected.
        Show that the LabeledPoint class can access these variables only in LabeledPoint
        instances*/

import java.util.Objects;

public class Point {
    protected double x,y;

    public Point(double x, double y){
        setX(x);
        setY(y);
    }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public String toString() { return "Point{" + "x=" + x + ", y=" + y + '}'; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 4;
        int multiplicator = 2;
        return hash*multiplicator+Objects.hash(x, y);
    }
}
