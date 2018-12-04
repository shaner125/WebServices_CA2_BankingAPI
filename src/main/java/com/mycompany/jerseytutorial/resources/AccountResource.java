/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;
import com.mycompany.jerseytutorial.services.AccountService;
import com.mycompany.jerseytutorial.model.Account;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
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
        @GET
	public List<Account> getAccounts(@PathParam("customerId") int cid) {
    	System.out.println("getAllAccountsForCustomer..."+cid);
        return accountService.getAllAccounts(cid);
	}
        
        //GET request returning specific account by account number
        @GET
        @Path("/{accountId}")
        public Account getAccount(@PathParam("customerId") int cid, @PathParam("accountId") int aId) {
        return accountService.getAccount(cid, aId);
        }
        
        //POST request to create a new account
        @POST
        @Path("/create")
        public Account postAccount(@PathParam("customerId") int cid, Account a) {
	return accountService.createAccount(cid, a);
        }        
        
        //link path to the transactions resource for a specific account
        @Path("/{accountId}/transaction")
        public TransactionResource getTransactionResource() {
        System.out.println("getting Transaction Resource");
        return new TransactionResource();
        }
    
}
