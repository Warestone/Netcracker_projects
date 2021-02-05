package com.warestone_company.NCprojects.java.oop1;

import java.util.InputMismatchException;
import java.util.Objects;

public class Rectangle {

    private float length = 1.0f, width = 1.0f;

    public Rectangle(float length, float width) {
        setLength(length);
        setWidth(width);
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        if (length>0)this.length = length;
        else throw new InputMismatchException("Length of the rectangle must be above zero");
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if (width>0) this.width = width;
        else throw new InputMismatchException("Width of the rectangle must be above zero");
    }

    public double getArea() {
        return length*width;
    }

    public double getPerimeter() {
        return 2*(width+length);
    }

    @Override
    public String toString() {
        return "Rectangle[length="+length+",width="+width+']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Float.compare(rectangle.length, length) == 0 && Float.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        final int hash = 11;
        final int multiplier = 2;
        return  hash * multiplier + Math.round(length+width);
    }
}
