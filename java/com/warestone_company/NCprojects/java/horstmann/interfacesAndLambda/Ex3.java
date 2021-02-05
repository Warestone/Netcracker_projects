package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;

import javax.imageio.stream.ImageInputStream;
import java.util.Scanner;

        /*What are all the supertypes of String? Of Scanner? Of ImageOutputStream? Note
        that each type is its own supertype. A class or interface without declared
        supertype has supertype Object.*/

public class Ex3 {

        public void printSupertypes(){
            System.out.println("String supertype: "+String.class.getSuperclass());      // serializable, comparable, char sequence, object
            System.out.println("Scanner supertype: "+ Scanner.class.getSuperclass());   // Iterator, closable, object
            System.out.println("ImageOutputStream supertype: "+ ImageInputStream.class.getSuperclass()); // /autoCloseable, closeable, dataInput, dataOutput, imageInputStream,object
        }
}
