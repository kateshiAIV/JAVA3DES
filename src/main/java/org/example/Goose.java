package org.example;

import org.example.gusi.Q;

public class Goose implements Runnable{
    Q q;
    Thread t;
    private String name;
    public Goose(Q q, String name){
        t = new Thread(this, name);
        this.q = q;
        this.name = name;
    }

    public String getName(){
        return name;
    }


    @Override
    public void run() {
        while (true){
            q.stealStones(1, this);
        }
    }
    public void start(){
        t.start();
    }

}
