/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.model;
import java.util.List;

/**
 *
 * @author shane
 */

public class Account {
    
    private int accountNumber;
    private int sortCode;
    private double currentBalance;
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(int accountNumber, int sortCode, double currentBalance, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.currentBalance = currentBalance;
        this.transactions = transactions;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    
    
}
