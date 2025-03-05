package org.example;

import java.util.Scanner;

public class Foreach {
    public static void main(String args[]){
        int table[][] = new int[3][5];
        for (int i =0;i<3;i++){
            for (int j= 0; j<5;j++) {
                table[i][j] = (j + 1) * (i + 1);
            }
        }
        for(var x: table){
            for(var y:x){
                System.out.print(y + " ");
            }
        }
    }
}
