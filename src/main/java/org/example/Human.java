package org.example;

public class Human {
    private String name, surname;
    private int age;
    public Human(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public void whoAmI(){
        System.out.println("I am " + name + surname + age);
    }
}
