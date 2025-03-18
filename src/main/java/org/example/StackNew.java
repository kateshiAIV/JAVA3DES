package org.example;

public class StackNew implements StackInt{

    int Stack[];
    int ctr = -1;
    StackNew(int size){
        Stack = new int[size];
    }
    @Override
    public int pull() {
        if (ctr < 0){
            System.out.println("Stack is empty");
            return 0;
        }
        System.out.println("Element: " + ctr);
        return Stack[ctr--];
    }

    @Override
    public void push(int a) {
        if(ctr == Stack.length){
            System.out.println("Stack is full");
        }
        else{
            ctr++;
            Stack[ctr] = a;
            System.out.println("Pushed at : " + ctr);
        }
    }
}
