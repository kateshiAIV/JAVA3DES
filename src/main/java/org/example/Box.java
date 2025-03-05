package org.example;

public class Box {
    int stackNum;
    int stack[] = new int[12];

    Box(){
        stackNum = 0;
    }

    public void push(int i){
        if(stackNum>12){
            System.out.println("Stack is full");
        }
        else{
            System.out.println("pushed " + i);
            stack[++stackNum]=i;
        }
    }
    public int pop(){
        int ret = 0;
        if(stackNum<0){
            System.out.println("Stack is empty");
        }
        else{
            ret = stack[stackNum--];
            System.out.println("poped " + ret);
        }
        return ret;
    }

}
