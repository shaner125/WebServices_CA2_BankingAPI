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
    private List<Customer> cList = DatabaseStub.getCustomerList();
 
    //method to lodge transaction to customer account by account number
    public Transaction makeLodgement(int cid, int aid, Transaction t){
        List<Account> tmpList = cList.get(cid-1).getAccounts();
//        return tmpList.get(aId-1);
          for (Account account : tmpList){
              if(account.getAccountNumber() == aid){
                  double tmpBalance = account.getCurrentBalance() + t.getAmount();
                  account.setCurrentBalance(tmpBalance);
                  account.getTransactions().add(t);
                  t.setPostBalance(tmpBalance);
                  return t;
              }
          }
        return null;
    }
    
    //method to withdraw transaction from account by account number
    public Transaction makeWithdrawel(int cid, int aid, Transaction t){
        List<Account> tmpList = cList.get(cid-1).getAccounts();
//        return tmpList.get(aId-1);
          for (Account account : tmpList){
              if(account.getAccountNumber() == aid){
                  double tmpBalance = account.getCurrentBalance() - t.getAmount();
                  account.setCurrentBalance(tmpBalance);
                  account.getTransactions().add(t);
                  t.setPostBalance(tmpBalance);
                  return t;
              }
          }
        return null;
    }
    
    //method to withdraw transaction from customer account and lodge to recipient account
    public Transaction makeTransfer(int cid, int aid,int recipientCustId, int recipientAccId, Transaction t){
        System.out.println("Transferring "+t.getAmount()+" from "+cid+": "+aid+" to: "+recipientCustId + " :"+recipientAccId);
        makeWithdrawel(cid,aid,t);
        makeLodgement(recipientCustId,recipientAccId,t);
        return t;
    }
    
    }

