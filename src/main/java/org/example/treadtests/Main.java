package org.example.treadtests;

public class Main {
    public static void main(String args[]){
        Printer p = new Printer();
        Thread3 t1 = new Thread3("Test3", 1000, p, "text dla printera");
        t1.start();
        Thread3 t2 = new Thread3("Test3", 1000, p, "text dla printera");
        t2.start();
        Thread3 t3 = new Thread3("Test3", 1000, p, "text dla printera");
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of main thread");

    }
}
