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
    
        private static DatabaseStub database = new DatabaseStub();
        public static List<Customer> cList = database.getCustomerList();
        
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
        public static void updateCustomer(int cid, Customer customer){
        System.out.println("updating customer.."+customer.getName());
//        cList.remove(cid-1);
        cList.set(cid-1, customer);
        System.out.println(cList.get(cList.size()-1).getName()+cList.get(cList.size()-1).getAccounts().get(0).getTransactions());
    }

}
