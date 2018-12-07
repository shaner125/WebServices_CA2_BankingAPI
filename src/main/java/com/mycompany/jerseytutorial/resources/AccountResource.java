/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;
import com.mycompany.jerseytutorial.services.AccountService;
import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Balance;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource{

    private AccountService accountService = new AccountService();
    
        // Get request returning list of accounts for a customer
        // e.g //e.g localhost:49000/api/customers/1/accounts
        @GET
	public List<Account> getAccounts(@PathParam("customerId") int cid) {
    	System.out.println("getAllAccountsForCustomer..."+cid);
        return accountService.getAllAccounts(cid);
	}
        
        //GET request returning specific account by account number
        // e.g //e.g localhost:49000/api/customers/1/accounts/11111
        @GET
        @Path("/{accountId}")
        public Account getAccount(@PathParam("customerId") int cid, @PathParam("accountId") int aId) {
        return accountService.getAccount(cid, aId);
        }
        
        //POST request to create a new account
        // e.g //e.g localhost:49000/api/customers/1/accounts/11111/create/current
        @POST
        @Path("/create/current")
        public Account postCurrentAccount(@PathParam("customerId") int cid) {
	return accountService.createCurrentAccount(cid);
        }   
        
        //POST request to create a new account
        //e.g localhost:49000/api/customers/1/accounts/11111/create/savings
        @POST
        @Path("/create/savings")
        public Account postSavingsAccount(@PathParam("customerId") int cid) {
	return accountService.createSavingsAccount(cid);
        }   
        
        // e.g. localhost:49000/api/customers/1/remove/11111
        @DELETE
        @Path("/remove/{accountId}")
        public Account removeAccount(@PathParam("accountId") int aid, @PathParam("customerId") int cid){
            return accountService.removeAccount(aid, cid);
        }
        
        // e.g //e.g localhost:49000/api/customers/1/accounts/11111/balance
        @GET
        @Path("/{accountId}/balance")
        public Balance getBalance(@PathParam("customerId") int cid, @PathParam("accountId") int aid){
            System.out.println("getting account balance...");
            return accountService.getBalance(cid, aid);
        }
        
        //link path to the transactions resource for a specific account
        @Path("/{accountId}/transaction")
        public TransactionResource getTransactionResource() {
        System.out.println("getting Transaction Resource");
        return new TransactionResource();
        }
    
}
