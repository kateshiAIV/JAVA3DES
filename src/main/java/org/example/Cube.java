package org.example;

public class Cube extends Square{
    public double height;

    Cube(double width, double length, double height){
        super(width, length);
        this.height = height;
    }
    public void Volume(){
        System.out.println(((width*height)*length));
    }
}
