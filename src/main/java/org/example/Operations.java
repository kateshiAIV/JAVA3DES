package org.example;

public class Operations {
    public static void main (String args[]){
        int a = 0b0000_0011; //3
        int b = 0b0000_0101; //5
        int op = a | b;
        System.out.println("operation OR: " + op);
        op = a & b;
        System.out.println("operation AND: " + op);
    }
}
