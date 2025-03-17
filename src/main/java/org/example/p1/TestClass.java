package org.example.p1;

//import org.example.p2.Bank;

class Animal {
    public void sound(){
        System.out.println("animal sound");
    }
}

class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("Woof");
    }
}

public class TestClass {
    public static void main(String args[]){
        int arr [] = {1 ,3,5,7,9};
        int target = 8;
        boolean found = false;
        for(int i=0; i<arr.length;i++){
            if(arr[i] == target || arr[i] % 2 ==0){
                found = false;
                break;
            }
        }
        System.out.println(found);
    }
}
