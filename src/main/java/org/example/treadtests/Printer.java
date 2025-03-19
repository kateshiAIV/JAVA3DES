package org.example.treadtests;

public class Printer {
    void print(String text){
        System.out.println("Brrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(text);
    }
}
