package com.company;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customer existCustomer = customers.get(i);
            if (existCustomer.getName().equals(customerName)) {
                return existCustomer;
            }
        }
        return null;
    }

    public boolean newCustomer(String customerName, double initialTransaction) {
        Customer tempCustomer = findCustomer(customerName);
        if (tempCustomer == null) {
            tempCustomer = new Customer(customerName, initialTransaction);
            this.customers.add(tempCustomer);
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        Customer tempCustomer = findCustomer(customerName);
        if (tempCustomer != null) {
            tempCustomer.addTransaction(transaction);
            return true;
        } else {
            return false;
        }
    }

}
