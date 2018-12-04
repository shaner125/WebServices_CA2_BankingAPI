/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;
import com.mycompany.jerseytutorial.model.Customer;
import com.mycompany.jerseytutorial.services.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author shane
 */
@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    

    CustomerService customerService = new CustomerService();
        
        //Get method returning all customers of bank, suitable for bank staff to use or for debugging
        @GET
        public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
        }
        
        //POST request to create a new banking customer
        @POST
        @Path("/create")
        public Customer createCustomer(Customer customer){
            return customerService.createCustomer(customer);
        }
        //GET method to retrieve customer by email
        @GET
        @Path("/getByEmail/{email}")
        public Customer getCustomerByEmail(@PathParam("email") String email){
            return customerService.getCustomerByEmail(email);
        }
        // GET method to retrieve customer information for a given customerID
        @GET
        @Path("/getById/{customerId}")
        public Customer getCustomer(@PathParam("customerId") int cId) {
            return customerService.getCustomer(cId);
        }
   
        //path linking accounts subresource
        @Path("/{customerId}/accounts")
        public AccountResource getAccountsResource() {
        System.out.println("getting Accounts Resource");
        return new AccountResource();
        }
    
}
