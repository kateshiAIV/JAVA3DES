package org.example.treadtests;

public class Thread2 implements Runnable {
    private Thread t;
    private int timing;

    public Thread2(String name, int timing) {
        this.timing = timing;
        t = new Thread(this, name); // Correct way to initialize the thread
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Current thread: " + Thread.currentThread().getName() + " : " + i);
                Thread.sleep(timing);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        t.start(); // Start the thread
    }
    public void join() throws InterruptedException {
        t.join(); // Start the thread
    }
}
