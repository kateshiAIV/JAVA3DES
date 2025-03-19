package org.example.treadtests;

public class Thread1 extends Thread{
    private int timing;
    Thread1(String name, int timing){
        super(name);
        this.timing = timing;
    }
    public void run(){
        try{
            for(int i = 0; i< 5;i++){
                System.out.println("Currend thread: " + this.getName() + " : " + i);
                Thread.sleep(timing);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
