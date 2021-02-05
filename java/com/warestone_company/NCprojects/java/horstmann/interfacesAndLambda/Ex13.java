package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

        /*Given an array of File objects, sort it so that directories come before files,
        and within each group, elements are sorted by path name. Use a lambda
        expression to specify the Comparator.
        */

public class Ex13 {

    public File[] sortFilesWithLambda(File[] inputFiles){
        List<File> directories = new ArrayList<>();
        List<File> files = new ArrayList<>();
        for (File file:inputFiles){
            if (file.isDirectory())directories.add(file);
            else files.add(file);
        }

        Comparator<File> comparator = Comparator.comparingInt((File file) -> file.getName().length());
        directories.sort(comparator);
        files.sort(comparator);

        List<File> allFiles = new ArrayList<>(directories);
        allFiles.addAll(files);
        return allFiles.toArray(new File[0]);
    }
}
