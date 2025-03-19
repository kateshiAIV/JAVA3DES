package org.example.gusi;

import org.example.Goose;

public class GusiMain {
    public static void main(String arg[]){
        Q q = new Q(2);
        Boy b = new Boy(q);
        Goose g1 = new Goose(q, "Гуся-сруся");
        Goose g2 = new Goose(q, "Гомогусь");
        Goose g3 = new Goose(q, "Гусь-Ебусь");

        g1.start();
        g2.start();
        g3.start();
        b.start();

    }
}
