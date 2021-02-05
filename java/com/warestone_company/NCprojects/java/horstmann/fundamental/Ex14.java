package com.warestone_company.NCprojects.java.horstmann.fundamental;

import java.util.*;

            /*Write a program that reads a two-dimensional array of integers and determines whether it is a magic square (that is, whether the sum of all
            rows, all columns, and the diagonals is the same). Accept lines of input
            that you break up into individual integers, and stop when the user enters
            a blank line. For example, with the input

            16 3 2 13
            5 10 11 8
            9 6 7 12
            4 15 14 1
            (Blank line)
            your program should respond affirmatively.*/

public class Ex14 {
    private int size;
    private List<int[]> matrix = new ArrayList<>();

    public Ex14(){ setMagicSquare(); }

    public void setMagicSquare(){
        System.out.println("Please, enter the size of matrix NxN N: ");
        Scanner scanner = new Scanner(System.in);
        try{ size = scanner.nextInt();}
        catch (InputMismatchException ignored) {setMagicSquare();};
        if (size<2) throw new InputMismatchException("Incorrect square size. Must be 2 or greater.");

        for (int i=1; i<=size; i++){
            System.out.println("Enter "+i+" row of "+size+"x"+size+" matrix with space as delimiter or empty row for continue:\n");
            try { matrix.add(getRowNumbers()); }
            catch (InputMismatchException ignored) {
                if (i==1) i=0;
                else i--;
            }
        }
    }

    private int[] getRowNumbers() throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);
        String row = scanner.nextLine();
        if (row.equals(""))System.exit(-1);
        String[] numbersString = row.split(" ");
        int[] numbersInt = new int[size];
        if (numbersString.length!=size) throw new InputMismatchException("Values in row must be " +size);
        int counter = 0;
        for (String digit : numbersString){
            try{ numbersInt[counter] = Integer.parseInt(digit);}
            catch (NumberFormatException ignored) {throw new InputMismatchException();}
            counter++;
        }
        return numbersInt;
    }

    public boolean checkMagicSquare(){
        int controlSum = Arrays.stream(matrix.get(0)).sum();
        int[] columnsSum = new int[size];
        int leftDiagonal = 0;
        int rightDiagonal = 0;

        int index = 0;
        for (int[] array : matrix){                                               // check rows and sum columns
            int sumArray = Arrays.stream(array).sum();
            if (sumArray!=controlSum) return false;

            leftDiagonal += array[index];
            rightDiagonal += array[size-1-index];
            for (int i=0; i<size; i++) columnsSum[i] += array[i];                 // sum columns
            index++;
        }

        if (Arrays.stream(columnsSum).sum()!=controlSum*size) return false;       // check columns

        return leftDiagonal == controlSum || rightDiagonal == controlSum;         //check diagonals
    }
}
