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
    
    public List<Transaction> getAllTransactions(int cid, int aid){
        List<Account> tmpList = cList.get(cid-1).getAccounts();
//        return tmpList.get(aId-1);
          for (Account account : tmpList){
              if(account.getAccountNumber() == aid){
                  return account.getTransactions();
              }
          }
          return null;
    }
    
    
    //method to lodge transaction to customer account by account number
    public Transaction makeLodgement(int cid, int aid, Transaction t){
        List<Account> tmpList = cList.get(cid-1).getAccounts();
//        return tmpList.get(aId-1);
          for (Account account : tmpList){
              if(account.getAccountNumber() == aid){
                  double tmpBalance = account.getCurrentBalance() + t.getAmount();
                  account.setCurrentBalance(tmpBalance);
                  t.setModifier("CREDIT");
                  account.getTransactions().add(t);
                  t.setPostBalance(tmpBalance);
                  return t;
              }
          }
        return null;
    }
    
    //method to withdraw transaction from account by account number
    public Transaction makeWithdrawal(int cid, int aid, Transaction t){
        List<Account> tmpList = cList.get(cid-1).getAccounts();
//        return tmpList.get(aId-1);
          for (Account account : tmpList){
              if(account.getAccountNumber() == aid){
                  if (account.getCurrentBalance() - t.getAmount() < 0){
                      return null;
                  }
                  else{
                  double tmpBalance = account.getCurrentBalance() - t.getAmount();
                  account.setCurrentBalance(tmpBalance);
                  t.setModifier("DEBIT");
                  account.getTransactions().add(t);
                  t.setPostBalance(tmpBalance);
                  return t;
                  }
              }
          }
        return null;
    }
    
    //method to withdraw transaction from customer account and lodge to recipient account
    public Transaction makeTransfer(int cid, int aid,int recipientCustId, int recipientAccId, Transaction t){
        System.out.println("Transferring "+t.getAmount()+" from "+cid+": "+aid+" to: "+recipientCustId + " :"+recipientAccId);
        if(makeWithdrawal(cid,aid,t) == t){
        makeLodgement(recipientCustId,recipientAccId,t);
        return t;
        }
        return null;
    }
    
    }

