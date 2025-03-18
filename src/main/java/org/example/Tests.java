package org.example;

public class Tests {
    public static void main(String args[]){


        StackNew s1 = new StackNew(10);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.pull();
        s1.pull();
        s1.pull();
        s1.pull();
    }
}
