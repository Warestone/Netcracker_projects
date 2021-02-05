package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;

import java.util.Arrays;

        /*Implement a static of method of the IntSequence class that yields a sequence
        with the arguments. For example, IntSequence.of(3, 1, 4, 1, 5, 9) yields a
        sequence with six values. Extra credit if you return an instance of an
        anonymous inner class.

        5. Add a static method with the name constant of the IntSequence class that
        yields an infinite constant sequence. For example, IntSequence.constant(1)
        yields values 1 1 1..., ad infinitum. Extra credit if you do this with a
        lambda expression.*/

public class IntSequenceImpl implements IntSequence {

    @FunctionalInterface
    interface LambdaInterface{ void printValue();}

    public IntSequence intSequence = new IntSequence() {
        public String of(int... arguments) {
            return String.join(", ", Arrays.toString(arguments));
        }
    };

    public IntSequence of(){ return intSequence; }

    @Override
    public String of(int... arguments) { return intSequence.of(arguments); }

    public void constant(int value){
        //LambdaInterface lambdaInterface = () -> {while (true) System.out.println(value+" ");};
        while (true) System.out.println(value+" ");
    }
}
