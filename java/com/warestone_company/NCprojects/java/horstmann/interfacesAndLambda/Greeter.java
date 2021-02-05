package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;

import java.util.InputMismatchException;

        /*Implement a class Greeter that implements Runnable and whose run method
        prints n copies of "Hello, " + target, where n and target are set in the constructor. Construct two instances with different messages and execute
        them concurrently in two threads.*/

public class Greeter {
    private int n;
    private String target;

    public Greeter(int n, String target)
    {
        if (n<0 || target == null) throw new InputMismatchException("There must positive N and target isn't null");
        this.n = n;
        this.target = target;
    }

    public void startPrinting(){
        new Thread(() -> {
            int itr = n;
            while (itr>0){
                System.out.println("Hello, "+target);
                itr--;
            }}).start();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter(5,"John");
        greeter.startPrinting();
        Greeter greeter2 = new Greeter(5,"Warestone");
        greeter2.startPrinting();
    }
}
