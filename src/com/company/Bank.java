package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getBranchName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName) {
        Branch tempBranch = findBranch(branchName);
        if (tempBranch == null) {
            tempBranch = new Branch(branchName);
            this.branches.add(tempBranch);
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomer(String customerName, String branchName, double initialAmount) {
        Branch tempBranch = findBranch(branchName);
        if (tempBranch != null) {
            return tempBranch.newCustomer(customerName, initialAmount);
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, String branchName, double transaction) {
        Branch tempBranch = findBranch(branchName);
        if (tempBranch != null) {
            return tempBranch.addCustomerTransaction(customerName, transaction);
        } else {
            return false;
        }
    }

    public boolean listCustomers(String nameOfBranch, boolean printTransactions) {
        Branch tempBranch = findBranch(nameOfBranch);
        if (tempBranch != null && printTransactions) {
            System.out.println("Customer details for branch " + tempBranch.getBranchName());
            for (int i = 0; i < tempBranch.getCustomers().size(); i++) {
                System.out.println("Customer: " + tempBranch.getCustomers().get(i).getName() + "[" + (i + 1) + "]");
                System.out.println("Transactions");
                for (int j = 0; j < tempBranch.getCustomers().get(i).getTransactions().size(); j++) {
                    System.out.println("[" + (j + 1) + "]  Amount " + tempBranch.getCustomers().get(i).getTransactions().get(j));
                }
            }
            return true;
        } else if (tempBranch != null) {
            System.out.println("Customer details for branch " + tempBranch.getBranchName());
            for (int i = 0; i < tempBranch.getCustomers().size(); i++) {
                System.out.println("Customer: " + tempBranch.getCustomers().get(i).getName() + "[" + (i + 1) + "]");
            }
            return true;
        } else {
            return false;
        }
    }
}
