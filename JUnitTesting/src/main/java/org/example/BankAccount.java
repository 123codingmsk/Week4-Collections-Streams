package org.example;

public class BankAccount {
    double balance = 0;
    public boolean deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("New balance: "+balance);
            return true;
        }
        System.out.println("Cant deposit, enter positive number");
        return false;
    }

    public boolean withdraw(double amount){
        if(amount > 0 && balance > amount){
            balance -= amount;
            System.out.printf("New balance: "+balance);
            return true;
        }
        System.out.println("Insufficient funds");
        return false;
    }

    public double getBalance(){
        return balance;
    }
}
