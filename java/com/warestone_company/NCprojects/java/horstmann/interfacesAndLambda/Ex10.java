package com.warestone_company.NCprojects.java.horstmann.interfacesAndLambda;

        /*Implement methods
        public static void runTogether(Runnable... tasks)
        public static void runInOrder(Runnable... tasks)

        The first method should run each task in a separate thread and then return. The second method should run all methods in the current thread
        and return when the last one has completed.
        */

public class Ex10 {

    public static void runTogether(Runnable... tasks){
       Runnable run = () ->{
           for (Runnable task:tasks) new Thread(task).start();
       };
    }
    public static void runInOrder(Runnable... tasks){
        Runnable run = () ->{
            for (Runnable task:tasks) task.run();
        };
    }

}
