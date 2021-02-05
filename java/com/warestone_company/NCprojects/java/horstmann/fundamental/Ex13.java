package com.warestone_company.NCprojects.java.horstmann.fundamental;

        /*Write a program that prints a lottery combination, picking six distinct
        numbers between 1 and 49. To pick six distinct numbers, start with an
        array list filled with 1...49. Pick a random index and remove the element.
        Repeat six times. Print the result in sorted order.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex13 {

    public void printLotteryBillet(){
        List<List<Integer>> allNumbers = new ArrayList<>();
        for (int i=0; i<6; i++) allNumbers.add(getElementMassive());

        List<Integer> lotteryBillet = new ArrayList<>();
        for (int i=0; i<6; i++){
            for(List<Integer> founded : allNumbers){
                int randomIndex = (int) (Math.random() * founded.size());
                lotteryBillet.add(founded.get(randomIndex));
                founded.remove(randomIndex);
            }
        }

        Collections.sort(lotteryBillet);
        System.out.println("Your lottery billet:\n");
        int counter = 1;
        for (int number : lotteryBillet){
            if (counter > 6){
                counter = 1;
                System.out.println();
                System.out.print(number + " ");
            }
            else System.out.print(number + " ");
            counter++;
        }
    }

    private List<Integer> getElementMassive(){
        List<Integer> elementList = new ArrayList<>();
        for (int i=1; i<=49; i++) elementList.add(i);
        return elementList;
    }
}
