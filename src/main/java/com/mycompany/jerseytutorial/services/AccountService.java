/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;
import com.mycompany.jerseytutorial.database.DatabaseStub;
import com.mycompany.jerseytutorial.model.Customer;
import com.mycompany.jerseytutorial.model.Account;
import java.util.ArrayList;
import java.util.Iterator;
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
        
        // accepts a JSON account object and adds it to a customers account
        public Account createAccount(int cId, Account a) {
            System.out.println("attempting to create account...");
            for(Customer customer : cList){
                if (customer.getCustomerID() == cId){
                customer.getAccounts().add(a);
                cList.get(cId-1).setAccounts(customer.getAccounts());
            }
        }
            System.out.println("Account created"+a.getAccountNumber());
            return a;
            
        }
    }

