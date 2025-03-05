package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Box stack = new Box();
        Scanner scan = new Scanner(System.in);
        int op;
        while (true){
            op = scan.nextInt();
            switch (op){
                case 1:{
                    System.out.println("push: ");
                    stack.push(scan.nextInt());
                    break;
                }
                case 2:{
                    System.out.println("pop: "+ stack.pop());
                    break;
                }
            }
        }
    }
}