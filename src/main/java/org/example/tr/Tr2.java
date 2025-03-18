package org.example.tr;

import javax.naming.SizeLimitExceededException;

public class Tr2 extends Thread{
    Tr2(){
        super("Tr2 thread");
        System.out.println("Constuctor:" + this);
    }
    public void run(){


        try{
            for(int i = 0; i < 10; i++){
                System.out.println(this + ": " + i);
                Thread.sleep(1000);
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
