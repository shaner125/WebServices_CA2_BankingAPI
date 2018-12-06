/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;
import com.mycompany.jerseytutorial.database.DatabaseStub;
import com.mycompany.jerseytutorial.model.Customer;
import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Transaction;
import com.mycompany.jerseytutorial.model.Balance;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shane
 */
public class AccountService {
    //retrieves list of customers
    private List<Customer> cList = DatabaseStub.getCustomerList();
 
    //retrieves all accounts for customer
    public List<Account> getAllAccounts(int cid){
        System.out.println("getting accounts");
        System.out.println("getting accounts");
        return cList.get(cid-1).getAccounts();
    }
    
    //retrieves specific account by looping through accounts until it finds an account number match
    public Account getAccount(int cId, int aId){
        List<Account> tmpList = cList.get(cId-1).getAccounts();
//        return tmpList.get(aId-1);
          for (Account account : tmpList){
              if(account.getAccountNumber() == aId){
                  return account;
              }
          }
          return null;
    }
    
    //returns balance of specified account
    public Balance getBalance(int cid,int aid){
        Balance newBalance = new Balance();
        List<Account> tmpList = cList.get(cid-1).getAccounts();
          for (Account account : tmpList){
              if(account.getAccountNumber() == aid){
                  newBalance.setBalance(account.getCurrentBalance());
                  System.out.println(newBalance.getBalance());
                  return newBalance;
              }
          }
          return newBalance;
    }
    
        
        // creates new current account and adds it to customer profile
        public Account createCurrentAccount(int cId) {
            Account a = new Account();
            a.setAccountNumber((int)(Math.random()*1001+100000));
            a.setCurrentBalance(0.0);
            a.setSortCode((int)(Math.random()*1001+10000));
            System.out.println("attempting to create account...");
            for(Customer customer : cList){
                if (customer.getCustomerID() == cId){
                    List<Transaction> newList = new ArrayList();
                    a.setTransactions(newList);
                customer.getAccounts().add(a);
                cList.get(cId-1).setAccounts(customer.getAccounts());
            }
        }
            System.out.println("Account created"+a.getAccountNumber());
            return a;
            
        }
        
        public Account createSavingsAccount(int cId) {
            Account a = new Account();
            a.setAccountNumber((int)(Math.random()*1001+100000));
            a.setCurrentBalance(0.0);
            a.setSortCode((int)(Math.random()*1001+10000));
            System.out.println("attempting to create account...");
            for(Customer customer : cList){
                if (customer.getCustomerID() == cId){
                    List<Transaction> newList = new ArrayList();
                    a.setTransactions(newList);
                customer.getAccounts().add(a);
                cList.get(cId-1).setAccounts(customer.getAccounts());
            }
        }
            System.out.println("Account created"+a.getAccountNumber());
            return a;
            
        }
}

