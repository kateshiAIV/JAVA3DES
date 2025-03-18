package org.example.tr;

public class TrMain {
    public static void main(String args[]){

    TestThread t1 = new TestThread("t1", 1000);
    t1.start();
    TestThread t2 = new TestThread("t2", 2000);
    t2.start();
    TestThread t3 = new TestThread("t3", 3000);
    t3.start();

    try{
        t1.join();
        t2.join();
        t3.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Main thread finished");

    }
}
