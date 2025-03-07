package org.example.p1;

//import org.example.p2.Bank;

public class Client {
    String name;
    public int age;
    protected Bank bank;
    private long money;
    Client(Bank b1){
        this.name = "Lolek";
        this.age = 20;
        this.bank = b1;
        this.money = 0;
    }
    public void display(){
        System.out.println("name: "+ name + ", age: " + age + ", Bank: "+ bank.name +", Value: " + money);
    }
}
