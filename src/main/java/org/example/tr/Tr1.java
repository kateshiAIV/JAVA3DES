package org.example.tr;

public class Tr1 implements Runnable {
    Thread t;
    Tr1(){
        t = new Thread(this,"Tr1 thread");
    }

    @Override
    public void run() {
        try{
            for(int i= 0; i<5;i++){
                System.out.println(t.getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
