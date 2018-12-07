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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
        //e.g. localhost:49000/api/customers
        @GET
        public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
        }
        
        //POST request to create a new banking customer
        //e.g localhost:49000/api/customers/create
        @POST
        @Path("/create")
        public Customer createCustomer(Customer customer){
            return customerService.createCustomer(customer);
        }
        
        @DELETE
        @Path("/remove/{customerId}")
        public Customer removeCustomerById(@PathParam("customerId") int cid){
            return customerService.removeCustomerById(cid);
        }
        
        //GET method to retrieve customer by email
        //e.g localhost:49000/api/customers/getByEmail/Shane.Ryan@student.ncirl.ie
        @GET
        @Path("/getByEmail/{email}")
        public Customer getCustomerByEmail(@PathParam("email") String email){
            return customerService.getCustomerByEmail(email);
        }
        // GET method to retrieve customer information for a given customerID
        //e.g localhost:49000/api/customers/getById/1
        @GET
        @Path("/getById/{customerId}")
        public Customer getCustomer(@PathParam("customerId") int cId) {
            return customerService.getCustomer(cId);
        }
        
        //update customer address
        //e.g. localhost:49000/api/customers/1/changeAddress
        @PUT
        @Path("/{customerId}/changeAddress")
        public Customer changeCustomerAddress(@PathParam("customerId") int cId, Customer c) {
            return customerService.changeCustomerAddress(cId, c);
        }
   
        //path linking accounts subresource
        //e.g localhost:49000/api/customers/1/accounts
        @Path("/{customerId}/accounts")
        public AccountResource getAccountsResource() {
        System.out.println("getting Accounts Resource");
        return new AccountResource();
        }
    
}
