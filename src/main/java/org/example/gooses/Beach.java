package org.example.gooses;

public class Beach {

    int stones = 1;

    Beach(int stones){
        this.stones = stones;
    }


    public synchronized void throwStones (){
        stones++;
        System.out.println("Stone thrown: " + stones);
    }

    public synchronized void stealStones(){
        stones--;
        System.out.println("Stone stealed: " + stones);
    }


}
