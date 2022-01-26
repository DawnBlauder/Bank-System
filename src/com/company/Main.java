package com.company;

public class Main {

    public static void main(String[] args) {
                Bank bank=new Bank("Type Bank name");
                bank.addBranch("Add branch name");
                bank.addCustomer("Add customer name","Add branch name",0);// taking initial amount
                bank.addCustomerTransaction("Add customer name","Add branch name",0);//taking transaction
                bank.listCustomers("Add branch name",true);// write false for not printing transactions.

    }

}
