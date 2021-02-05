package com.warestone_company.NCprojects.java.oop1;

import java.util.InputMismatchException;

import static java.lang.Math.*;

public class MyPoint {

    private int x = 0,y = 0;

    public MyPoint(int x, int y){
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public int[] getXY(){
        return new int[]{x,y};
    }

    public void setXY(int x, int y){
        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return '(' + x + "," + y + ')';
    }

    public double distance(int x, int y){
        return sqrt(pow((this.x-x),2) + pow((this.y-y),2));
    }

    public double distance(MyPoint point){
        if (point==null) throw new InputMismatchException("Input point don't be null");
        return distance(point.getX(),point.getY());
    }

    public double distance(){
       return distance(0,0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPoint myPoint = (MyPoint) o;
        return x == myPoint.x && y == myPoint.y;
    }

    @Override
    public int hashCode() {
        final int hash = 9;
        final int multiplier = 2;
        return (hash * multiplier + x + y);
    }
}
