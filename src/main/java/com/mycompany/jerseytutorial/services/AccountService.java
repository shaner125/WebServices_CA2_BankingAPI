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
public class AccountService extends CustomerService {

    public AccountService() {
        super(database);
    }
    
    public List<Account> getAllAccounts(int cId){
        List<Customer> cList = database.customerList;
        System.out.println("getting accounts"+cId);
        return cList.get(cId).getAccounts();
    }
    
//        public Account createAccount(int cId, Account a) {
//	for (Customer customer : DatabaseStub.customerList){
//            if(customer.getCustomerID() == cId){
//                List<Account> tmpAList = customer.getAccounts();
//                tmpAList.add(a);
//                customer.setAccounts(tmpAList);
//                System.out.println("New account "+a.getAccountNumber()+" has been created for customer "+customer.getName());
//            }
//        }
//	return a;
//    }
}
