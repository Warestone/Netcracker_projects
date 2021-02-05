package com.warestone_company.NCprojects.java.horstmann.object;

        /*Implement an immutable class Point that describes a point in the plane.
        Provide a constructor to set it to a specific point, a no-arg constructor to
        set it to the origin, and methods getX, getY, translate, and scale. The translate
        method moves the point by a given amount in x- and y-direction. The
        scale method scales both coordinates by a given factor. Implement these
        methods so that they return new points with the results.

        For example,
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        should set p to a point with coordinates (2, 3.5).
        */

public final class Point {
    private double x,y;

    public Point(){
        x = 0;
        y = 0;
    }

    public Point(double x, double y){
        setX(x);
        setY(y);
    }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double getX() { return x; }
    public double getY() { return y; }

    public void translate(double x, double y){
        this.x+=x;
        this.y+=y;
    }

    public void scale(double scaleValue){
        x*=scaleValue;
        y*=scaleValue;
    }


}
