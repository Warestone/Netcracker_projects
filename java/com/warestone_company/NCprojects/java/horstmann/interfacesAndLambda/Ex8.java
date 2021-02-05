package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

        /*. Implement the method void luckySort(ArrayList<String> strings, Comparator<String>
        comp) that keeps calling Collections.shuffle on the array list until the elements
        are in increasing order, as determined by the comparator.
        */

public class Ex8 {
    public void luckySort(ArrayList<String> strings, Comparator<String> comp){
        List<String> sortedStrings = new ArrayList<String>(strings);
        sortedStrings.sort(comp);
        while (!strings.equals(sortedStrings)) Collections.shuffle(strings);
    }
}
