package org.example;

public class Square {
    protected double width, length;
    Square(double width, double length){
        this.width = width;
        this.length = length;
    }
    public void P(){
        System.out.println(width*length);
    }

}
