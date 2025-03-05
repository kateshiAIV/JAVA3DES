package org.example;

import java.util.Scanner;

public class Foreach {
    public static void main(String args[]){

        for(int i = 0; i <10;i++){
            System.out.print(";");
            System.out.print(i + " ");
            if(i%2==0)continue;
            System.out.println(":");
        }

    }
}
