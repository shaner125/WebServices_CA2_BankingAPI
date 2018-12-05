/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;
import com.mycompany.jerseytutorial.model.Customer;
import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.database.DatabaseStub;
import java.util.ArrayList;



import java.util.List;

/**
 *
 * @author shane
 */
public class CustomerService {
    
        private static final DatabaseStub database = new DatabaseStub();
        public static List<Customer> cList = DatabaseStub.getCustomerList();
         
        //method to create new customer
        public Customer createCustomer(Customer customer){
            List<Account> newList = new ArrayList();
            customer.setCustomerID(cList.size()+1);
            customer.setAccounts(newList);
            cList.add(customer);
            return customer;
        }
        
        //method to retrieve all bank customers
        public List<Customer> getAllCustomers(){
            return cList;
        }
        
        //method to retrive customer by Email
        public Customer getCustomerByEmail(String email){
            for (Customer customer : cList){
                if (customer.getEmail() == null ? email == null : customer.getEmail().equals(email)){
                    return customer;
                }
            }
            return null;
        }
        
        //method to get customer by customer ID
        public Customer getCustomer(int cId){
            return cList.get(cId-1);
        }   
        
        //method to update customer after changes to accounts / transfers
        public static void updateCustomer(int cid, Customer customer){
        System.out.println("updating customer.."+customer.getName());
        cList.set(cid-1, customer);
    }

}
