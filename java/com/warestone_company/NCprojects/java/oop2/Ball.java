package com.warestone_company.NCprojects.java.oop2;

import java.util.InputMismatchException;
import java.util.Objects;

public class Ball {

    private float x,y,xDelta,yDelta;
    private int radius,speed,direction;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        setRadius(radius);
        setSpeed(speed);
        setDirection(direction);
        xDelta = (float) (speed * Math.cos(Math.PI*direction/180));
        yDelta = (float) (-speed * Math.sin(Math.PI*direction/180));
    }

    public float getX() { return x; }

    public float getY() { return y; }

    public int getRadius() { return radius; }

    public float getXDelta() { return xDelta; }

    public float getYDelta() { return yDelta; }

    public int getSpeed() { return speed; }

    public void setX(float x) { this.x = x; }

    public void setY(float y) { this.y = y; }

    public void setXDelta(float xDelta) { this.xDelta = xDelta; }

    public void setYDelta(float yDelta) { this.yDelta = yDelta; }

    public void setRadius(int radius) {
        if (radius<=0) throw new InputMismatchException();
        this.radius = radius;
    }

    public void setSpeed(int speed) {        // speed may be zero for jumping on one place
        if (speed<0) throw new InputMismatchException("Speed must don't be below zero");
        this.speed = speed;
    }

    public void setDirection(int direction) {
        if (direction > 180 || direction <-180) throw new InputMismatchException("Direction must be between -180 and +180");
        this.direction = direction;
    }

    public void move(){
        x+=xDelta;
        y+=yDelta;
    }

    public void reflectHorizontal() { xDelta =-xDelta; }

    public void reflectVertical() { xDelta =-yDelta; }

    @Override
    public String toString() { return "Ball[(" + x + ',' + y + "),speed=(" + xDelta + ',' + yDelta + ")]"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Float.compare(ball.x, x) == 0 && Float.compare(ball.y, y) == 0 && radius == ball.radius && speed == ball.speed && direction == ball.direction;
    }

    @Override
    public int hashCode() {
        final int hash = 3;
        final int multiplier = 7;
        return  hash * multiplier + Math.round(x + y)  + radius + speed + direction;
    }
}
