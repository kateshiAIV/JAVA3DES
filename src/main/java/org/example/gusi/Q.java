package org.example.gusi;

import org.example.Goose;

public class Q  {
    private int stones = 0;
    private boolean bVal = false; // false -> boy's turn, true -> geese's turn

    Q(int stones) {
        this.stones = stones;
    }

    public synchronized void stealStones(int val, Goose g) {

            while (!bVal || stones <= 0) {
                if (stones <= 0) {
                    System.out.println("Все камни украдены! Гуси отдыхают...");
                    notifyAll();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (stones - val < 0) {
                val = stones;
            }
            stones -= val;
            System.out.println("Гуся по кличке " + g.getName() + " спиздил " + val + " камень(ей)");
            System.out.println("Осталось " + stones + " камушков");

            if (stones == 0) {
                bVal = false;
            }

            notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public synchronized void throwStones(int val) {

            while (bVal) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            stones += val;
            System.out.println("Мальчик кинул " + val + " камней");
            System.out.println("Теперь на пляже " + stones + " камушков");

            bVal = true;
            notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
