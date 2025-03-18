package org.example.tr;

public class TestThread extends Thread{
    private int cooldown;
    TestThread(String name,int cooldown){
        super(name);
        this.cooldown = cooldown;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(this + ": " + i);
                sleep(cooldown);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
