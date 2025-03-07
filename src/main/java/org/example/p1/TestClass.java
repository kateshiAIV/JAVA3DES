package org.example.p1;

//import org.example.p2.Bank;

public class TestClass {
    public static void main(String args[]){
        System.out.println("Hello");
        Bank b1 = new Bank();
        Client c1 = new Client(b1);
        c1.display();
    }
}
