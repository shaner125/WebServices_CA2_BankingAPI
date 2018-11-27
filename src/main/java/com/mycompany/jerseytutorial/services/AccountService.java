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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shane
 */
public class AccountService {
    
        public Account createAccount(int cId, Account a) {
	for (Customer customer : DatabaseStub.customerList){
            if(customer.getCustomerID() == cId){
                List<Account> tmpAList = customer.getAccounts();
                tmpAList.add(a);
                customer.setAccounts(tmpAList);
                System.out.println("New account "+a.getAccountNumber()+" has been created for customer "+customer.getName());
            }
        }
	return a;
    }
}
