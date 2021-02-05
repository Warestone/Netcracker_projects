package com.warestone_company.NCprojects.java.spring.lab_1.ioFile;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile {
    public ArrayList<String> readUsersFile(Logger logger){
        ArrayList<String>usersList = new ArrayList<>();
        try{
            File file = new File("out\\users.txt");
            if (file.exists())
            {
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                while (line != null) {
                    usersList.add(line);
                    line = reader.readLine();
                }
            }
            else return null;
        } catch (IOException e) {
            logger.log(Level.WARNING, "can't read users.txt file.\nError: "+e.getMessage());
            return null;
        }
        logger.info("successfully read file users.txt.");
        return usersList;
    }
}
