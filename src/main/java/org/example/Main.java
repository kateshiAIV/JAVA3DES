package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Box b1 = new Box(10.1, 10.2);
        Box b2 = b1;
        System.out.print(b1.getHeight() + " " + b2.getHeight());
        b2.setHeight(1.1);
        System.out.print(b1.getHeight() + " " + b2.getHeight());
    }
}