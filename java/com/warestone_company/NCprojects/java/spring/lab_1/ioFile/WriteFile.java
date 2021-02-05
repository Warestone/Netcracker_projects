package com.warestone_company.NCprojects.java.spring.lab_1.ioFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteFile {
    public WriteFile(String line, Logger logger){
        try(FileWriter fileWriter = new FileWriter("out\\users.txt", true)) {
            fileWriter.write(line+"\n");
        }
        catch(IOException ex){
            logger.log(Level.WARNING,"Unable write new user to file.\nError message: "+ex);
        }
        logger.log(Level.INFO,"New user has been written.");
    }
}
