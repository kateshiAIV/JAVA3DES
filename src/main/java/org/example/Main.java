package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int size = 10;
        Rekurencja r = new Rekurencja(size);
        for (int i =0;i<size;i++){
            r.tab[i] = i;
        }
        r.printTab(size-1);

    }
}