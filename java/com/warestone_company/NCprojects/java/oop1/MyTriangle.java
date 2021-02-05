package com.warestone_company.NCprojects.java.oop1;

import java.util.InputMismatchException;
import java.util.Objects;

public class MyTriangle {

    private MyPoint point1, point2, point3;
    private enum triangleTypes {
        Equilateral,
        Isosceles,
        Scalene
    }

    public MyTriangle(MyPoint point1, MyPoint point2, MyPoint point3) {
        if (point1==null || point2==null || point3==null) throw new InputMismatchException("Input points don't be nulls");
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        point1 = new MyPoint(x1,y1);
        point2 = new MyPoint(x2,y2);
        point3 = new MyPoint(x3,y3);
    }

    @Override
    public String toString() {
        return "MyTriangle{" + "point1=" + point1 + ",point2=" + point2 + ",point3=" + point3 + '}';
    }

    private double[] getDistances(){
        return new double[]{point1.distance(point2), point2.distance(point3), point3.distance(point1)};
    }

    public double getPerimeter(){
        double[] distances = getDistances();
        return distances[0] + distances[1] + distances[2];
    }

    public String getType(){
        double[] distances = getDistances();
        double side1 = distances[0];
        double side2 = distances[1];
        double side3 = distances[2];
        if (Double.compare(side1,side2) == 0 && Double.compare(side2,side3) == 0) return triangleTypes.Equilateral.name();
        if (Double.compare(side1,side2) == 0 || Double.compare(side1,side3) == 0) return triangleTypes.Isosceles.name();
        if (Double.compare(side2,side3) == 0) return triangleTypes.Isosceles.name();
        else return triangleTypes.Scalene.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle that = (MyTriangle) o;
        return Objects.equals(point1, that.point1) && Objects.equals(point2, that.point2) && Objects.equals(point3, that.point3);
    }

    @Override
    public int hashCode() {
        final int hash = 10;
        final int multiplier = 2;
        return  hash * multiplier + Objects.hash(point1,point2, point3);
    }
}
