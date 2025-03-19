package org.example.gusi;

public class Boy implements Runnable{
    Q q;
    Thread t;
    public Boy(Q q){
        t = new Thread(this, "Boy");
        this.q = q;
    }
    public void run(){
        while(true){
            q.throwStones(1);
        }
    }
    public void start(){
        t.start();
    }


}
