package org.example;

public class Rekurencja {
    public int tab[];

    Rekurencja(int i){
        tab = new int[i];
    }
    void printTab(int j){
        if(j==0) System.out.println(tab[j] + " ");
        else {
            System.out.println(tab[j] + " ");
            printTab(j - 1);
        }
    }
}
