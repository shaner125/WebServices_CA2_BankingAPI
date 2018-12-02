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
import java.util.List;
/**
 *
 * @author shane
 */
public class AccountService {
    private List<Customer> cList = new DatabaseStub().getCustomerList();
 
    public List<Account> getAllAccounts(int cid){
        System.out.println("getting accounts");
        System.out.println("getting accounts");
        return cList.get(cid-1).getAccounts();
    }
    
    public Account getAccount(int cId, int aId){
        List<Account> tmpList = cList.get(cId-1).getAccounts();
        return tmpList.get(aId-1);
    }
    
        public Account createAccount(int cId, Account a) {
            System.out.println("attempting to create account...");
            List<Account> newList = new ArrayList();
            for (int i = 0; i<cList.size()-1; i++){
            if(cList.get(i).getCustomerID() == cId){
                List<Account> tmpAList = cList.get(i).getAccounts();
                tmpAList.add(a);
                cList.get(i).setAccounts(tmpAList);
            }
        }
            System.out.println("Account created"+a.getAccountNumber());
            return a;
            
        }
    }

