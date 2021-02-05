package com.warestone_company.NCprojects.java.oop2;

public class BallInBox {
    private static boolean outOfBox = false;

    public static void main(String[] args) {
        Container container = new Container(0,0,10,5);
        Ball ball = new Ball(3,3,1,1,70);
        System.out.println(container);
        System.out.println("Start position"+ball+"\n");
        while (!outOfBox){
            if (!container.collides(ball))
            {
                System.out.println(ball);
                ball.move();
            }
            else outOfBox = true;
        }
        System.out.println("\nBall is out of container borders!");
    }
}
