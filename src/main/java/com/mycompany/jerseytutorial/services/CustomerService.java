/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;
import com.mycompany.jerseytutorial.model.Customer;
import com.mycompany.jerseytutorial.database.DatabaseStub;



import java.util.List;

/**
 *
 * @author shane
 */
public class CustomerService {
    
        DatabaseStub database = new DatabaseStub();
        private List<Customer> cList = database.getCustomerList();
        
//        public Customer createCustomer(String name, String address, String email, String password) {
//            
//        Customer tmpCustomer = DatabaseStub.generateNewCustomer();
//        tmpCustomer.setName(name);
//        tmpCustomer.setAddress(address);
//        tmpCustomer.setEmail(email);
//        tmpCustomer.setPassword(password);
//        
//        DatabaseStub.customerList.add(tmpCustomer);
//            
//        return tmpCustomer;
//        }
        
        public List<Customer> getAllCustomers(){
            return cList;
        }
        
        public Customer getCustomer(int cId){
            return cList.get(cId-1);
        }   
}
