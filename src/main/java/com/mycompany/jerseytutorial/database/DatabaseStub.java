/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.database;

import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Transaction;
import com.mycompany.jerseytutorial.model.Transaction.TransactionType;
import com.mycompany.jerseytutorial.model.Customer;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author shane
 */
public class DatabaseStub {
    private static List<Customer> customerList = new ArrayList<>();
    private static List<Account> ac1 = new ArrayList<>();
    private static List<Account> ac2 = new ArrayList<>();
    private static List<Account> ac3 = new ArrayList<>();
    private static List<Account> ac4 = new ArrayList<>();
    private static List<Account> ac5 = new ArrayList<>();
    private static List<Transaction> a1Transactions = new ArrayList<>();
    private static List<Transaction> a2Transactions = new ArrayList<>();
    private static List<Transaction> a3Transactions = new ArrayList<>();
    private static List<Transaction> a4Transactions = new ArrayList<>();
    private static List<Transaction> a5Transactions = new ArrayList<>();
    private static boolean init = true;
    
    public DatabaseStub(){
    
    if (init) {
        

            Transaction t1 = new Transaction (TransactionType.LODGEMENT, 100.00, "20/01/2017","Opening account" );
            Transaction t2 = new Transaction (TransactionType.LODGEMENT, 150.00, "22/01/2017","Opening account" );
            Transaction t3 = new Transaction (TransactionType.LODGEMENT, 1200.00, "10/02/2017","Opening account" );
            Transaction t4 = new Transaction (TransactionType.LODGEMENT, 300.00, "22/05/2017","Opening account" );
            Transaction t5 = new Transaction (TransactionType.LODGEMENT, 124.69, "17/11/2017","Opening account" );
            
            a1Transactions.add(t1);
            a2Transactions.add(t2);
            a3Transactions.add(t3);
            a4Transactions.add(t4);
            a5Transactions.add(t5);

             Account a1 = new Account ((int)(Math.random() * 100001), (int)(Math.random() * 10001), 100.00,a1Transactions);
             Account a2 = new Account ((int)(Math.random() * 100001), (int)(Math.random() * 10001), 150.00,a2Transactions);
             Account a3 = new Account ((int)(Math.random() * 100001), (int)(Math.random() * 10001), 1200.00,a3Transactions);
             Account a4 = new Account ((int)(Math.random() * 100001), (int)(Math.random() * 10001), 300.00,a4Transactions);
             Account a5 = new Account ((int)(Math.random() * 100001), (int)(Math.random() * 10001), 124.69,a5Transactions);
             
             ac1.add(a1);
             ac2.add(a2);
             ac3.add(a3);
             ac4.add(a4);
             ac5.add(a5);
             
             Customer c1 = new Customer (1, "Shane", "32 Tyrone House", "Shane.Ryan@student.ncirl.ie", "password123", ac1);
             Customer c2 = new Customer (2, "Graeme", "123 Grove Lane", "Graeme.Doherty@student.ncirl.ie", "abc123", ac2);
             Customer c3 = new Customer (3, "James", "49 Evergreen Terrace", "James.Curran@student.ncirl.ie", "newpassword123", ac3);
             Customer c4 = new Customer (4, "Adam", "299 Vicker Street", "Adam.Grimbly@student.ncirl.ie", "thisisapassword123", ac4);
             Customer c5 = new Customer (5, "Paul", "114 O'Connell Drive", "Paul.Schmibly@student.ncirl.ie", "easypassword123", ac5);
             
             customerList.add(c1);
             customerList.add(c2);
             customerList.add(c3);
             customerList.add(c4);
             customerList.add(c5);
             System.out.println("testprint2");
        init = false;
     }
    

    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void updateCustomer(int cid, Customer customer){
        System.out.println("updating customer..");
        customerList.remove(cid-1);
        customerList.add(customer);
    }
    
//        public static Customer generateNewCustomer(){
//        Transaction openingTransaction = new Transaction (Transaction.TransactionType.LODGEMENT, 0.00, ""+new Date(),"Opening account" );
//                List<Transaction> openingTransactionList = new ArrayList();
//                openingTransactionList.add(openingTransaction);
//                Account newAccount = new Account ((int)(Math.random() * 100001), (int)(Math.random() * 10001), 0.00,openingTransactionList);
//                List<Account> openingAccountList = new ArrayList();
//                openingAccountList.add(newAccount);
//                Customer newCustomer = new Customer (DatabaseStub.customerList.size()+1, "", "", "", "", openingAccountList);
//                return newCustomer;
//    }
}
