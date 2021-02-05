package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;


import java.io.File;
import java.io.FileFilter;

        /*Using the list(FilenameFilter) method of the java.io.File class, write a method
        that returns all files in a given directory with a given extension. Use a
        lambda expression, not a FilenameFilter. Which variable from the enclosing
        scope does it capture?
        */

public class Ex12 {

    public File[] getAllFiles(File file, String extension){
        if (file.isDirectory()){
            FileFilter fileFilter = (File checkFile) -> checkFile.getName().endsWith(extension);
            return file.listFiles(fileFilter);
        }
        return null;
    }
}
