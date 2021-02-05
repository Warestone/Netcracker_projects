package com.warestone_company.NCprojects.java.horstmann.inheritanceAndReflection;

import java.util.InputMismatchException;
import java.util.Objects;

        /*1 Define a class Point with a constructor public Point(double x, double y) and
        accessor methods getX, getY. Define a subclass LabeledPoint with a constructor
        public LabeledPoint(String label, double x, double y) and an accessor method
        getLabel.*/

        /*2 Define toString, equals, and hashCode methods for the classes of the preceding
        exercise*/

        /*3 Make the instance variables x and y of the Point class in Exercise 1 protected.
        Show that the LabeledPoint class can access these variables only in LabeledPoint
        instances*/

public class LabeledPoint extends Point{
    private String label;

    public LabeledPoint(String label, double x, double y){
        super(x, y);
        if (label==null) throw new InputMismatchException("Label don't be null");
    }

    public String getLabel() { return label; }

    @Override
    public String toString() { return "LabeledPoint{" + "x=" + getX() + ", y=" + getY() + ", label='" + label + "'}"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LabeledPoint that = (LabeledPoint) o;
        return Double.compare(getX(), that.getX()) == 0 && Double.compare(getY(), that.getY()) == 0 && Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        int hash = 4;
        int multiplicator = 5;
        return hash*multiplicator+Objects.hash(getX(),getY(),label);
    }
}
