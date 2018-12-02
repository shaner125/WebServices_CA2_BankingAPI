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
import com.mycompany.jerseytutorial.resources.CustomerResource;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shane
 */
public class TransactionService {
    private List<Customer> cList = new DatabaseStub().getCustomerList();
 
    public Transaction makeLodgement(int cid, int aid, Transaction t){
        System.out.println("attempting to lodge: "+t.getAmount());
        Customer tmpCustomer = cList.get(cid-1);
        System.out.println("attempting to lodge: "+t.getAmount());
        Account tmpAccount = tmpCustomer.getAccounts().get(aid-1);
        System.out.println("attempting to lodge: "+t.getAmount());
        tmpAccount.setCurrentBalance(tmpAccount.getCurrentBalance() + t.getAmount());
        System.out.println("attempting to lodge: "+t.getAmount());
        tmpCustomer.getAccounts().get(aid-1).getTransactions().add(t);
        System.out.println("attempting to lodge: "+t.getAmount());
        CustomerService.updateCustomer(cid, tmpCustomer);

        return t;
    }
    
    public Transaction makeWithdrawel(int cid, int aid, Transaction t){
        return t;
    }
    
    public Transaction makeTransfer(int cid, int aid,int recipient, Transaction t){
        return t;
    }
    
    }

