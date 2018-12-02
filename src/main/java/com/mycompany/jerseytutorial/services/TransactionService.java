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
import java.util.List;
/**
 *
 * @author shane
 */
public class TransactionService {
    private List<Customer> cList = new DatabaseStub().getCustomerList();
 
    public Transaction makeLodgement(int cid, int aid, Transaction t){
        Customer tmpCustomer = cList.get(cid-1);
        Account tmpAccount = tmpCustomer.getAccounts().get(aid-1);
        tmpAccount.setCurrentBalance(tmpAccount.getCurrentBalance() + t.getAmount());
        tmpCustomer.getAccounts().get(aid-1).getTransactions().add(t);
        CustomerService.updateCustomer(cid, tmpCustomer);
        return t;
    }
    
    public Transaction makeWithdrawel(int cid, int aid, Transaction t){
        Customer tmpCustomer = cList.get(cid-1);
        Account tmpAccount = tmpCustomer.getAccounts().get(aid-1);
        tmpAccount.setCurrentBalance(tmpAccount.getCurrentBalance() - t.getAmount());
        tmpCustomer.getAccounts().get(aid-1).getTransactions().add(t);
        CustomerService.updateCustomer(cid, tmpCustomer);
        return t;
    }
    
    public Transaction makeTransfer(int cid, int aid,int recipient, Transaction t){
        System.out.println(recipient);
        makeLodgement(recipient,aid,t);
        makeWithdrawel(cid,aid,t);
        return t;
    }
    
    }

