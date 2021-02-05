package com.warestone_company.NCprojects.java.oop2;

import java.util.InputMismatchException;
import java.util.Objects;

public class Container {

    private int x1,y1,x2,y2;

    public Container(int x1, int y1, int width, int height) {
        if (width<=0 || height<=0) throw new InputMismatchException("Width & height of container must be above zero");
        this.x1 = x1;
        this.y1 = y1;
        x2 = x1 + width;
        y2 = y1 + height;
    }

    public int getX() { return x1; }

    public int getY() { return y1; }

    public int getWidth() { return x2-x1; }

    public int getHeight() { return Math.abs(y2+y1); }

    public boolean collides(Ball ball) {
        if (ball == null) throw new InputMismatchException("Ball must don't be null");
        float ballX = ball.getX() + ball.getRadius();
        float ballY = ball.getY() + ball.getRadius();
        if (ballX > x1 && ballX < x2)
        {
            return ballY < y1 && ballY < y2;
        }
        else return true;
    }

    @Override
    public String toString() { return "Container[(" + x1 + ',' + y1 + "),(" + x2 + ',' + y2 + ")]"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return x1 == container.x1 && y1 == container.y1 && x2 == container.x2 && y2 == container.y2;
    }

    @Override
    public int hashCode() {
        final int hash = 3;
        final int multiplier = 4;
        return  hash * multiplier + x1 + y1 + x2 + y2;
    }
}
