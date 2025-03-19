package org.example.treadtests;

public class Thread3 implements Runnable{
    private Thread t;
    private int timing;
    Printer p;
    String msg;
    Thread3(String name, int timing, Printer p, String msg){
        t = new Thread(this,name);
        this.timing = timing;
        this.p = p;
        this.msg = msg;
    }

    @Override
    public void run(){
        synchronized (p) {
            p.print(msg);
        }
    }
    public void start(){
        t.start();
    }
    public void join() throws InterruptedException{
        t.join();
    }



}
