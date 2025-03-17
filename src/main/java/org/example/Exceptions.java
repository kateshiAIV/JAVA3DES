package org.example;

public class Exceptions {
    public static void main(String args[]){
        try{
            throw new RuntimeException("debil");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
