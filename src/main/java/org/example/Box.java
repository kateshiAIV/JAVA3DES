package org.example;

public class Box {
    private double height;
    private double width;

    Box(double height, double width){
        this.height = height;
        this.width = width;
    }

    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setHeight(double height){
        this.height = height;
    }

}
