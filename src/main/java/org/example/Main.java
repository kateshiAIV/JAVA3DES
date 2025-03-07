package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Square s1 = new Square(8.0, 5.5);
        Cube c1 = new Cube(5.0,2.0,3.0);
        s1.P();
        c1.P();
        Square s2 = c1;
        s2.P();
        c1.Volume();

    }
}