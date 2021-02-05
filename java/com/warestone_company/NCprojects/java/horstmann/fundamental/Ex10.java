package com.warestone_company.NCprojects.java.horstmann.fundamental;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/*
        Write a program that produces a random string of letters and digits by
        generating a random long value and printing it in base 36.
*/
//      I don't what do with long value here :(

public class Ex10 {
    private final String upperCaseLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private final String numbers = "1234567890";

    public void printGeneratedStringInBase36(int length){
        String lettersAndNumbers = upperCaseLetters + upperCaseLetters.toLowerCase() + numbers;

        int totalSymbols = lettersAndNumbers.length() ;
        StringBuilder generatedString = new StringBuilder();
        for (int i=0; i<length; i++){
            int charIndex = (int) (Math.random()*totalSymbols);
            generatedString.append(lettersAndNumbers.charAt(charIndex));
        }
        System.out.println("Generated string: "+generatedString);
        System.out.println("Generated base36: "+convertToBase36(generatedString.toString()));
    }

    private String convertToBase36(String string){
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        String base36 = new BigInteger(1, bytes).toString(36);
        return base36;
    }
}
