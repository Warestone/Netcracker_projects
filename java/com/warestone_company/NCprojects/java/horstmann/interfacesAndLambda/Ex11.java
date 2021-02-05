package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

        /*Using the listFiles(FileFilter) and isDirectory methods of the java.io.File
        class, write a method that returns all subdirectories of a given directory.
        Use a lambda expression instead of a FileFilter object. Repeat with a
        method expression and an anonymous inner class.*/

public class Ex11 {

    public File[] getAllSubdirectoriesLambda(File file){
        if (file.isDirectory()){
            FileFilter fileFilter = File::isDirectory;
            return file.listFiles(fileFilter);
        }
        return null;
    }

    public File[] getAllSubdirectoriesExpression(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files!=null){
                List<File> foundedDirs = new ArrayList<>();
                for(File foundedFile:files){
                    if (foundedFile.isDirectory())foundedDirs.add(foundedFile);
                }
                return foundedDirs.toArray(new File[0]);
            }
        }
        return null;
    }
}
