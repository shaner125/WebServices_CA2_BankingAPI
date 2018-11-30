/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;
import com.mycompany.jerseytutorial.database.DatabaseStub;
import com.mycompany.jerseytutorial.model.Customer;
import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Transaction;
import com.mycompany.jerseytutorial.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
/**
 *
 * @author shane
 */
public class AccountResource{ 
    
    int customerId;

    public AccountResource(int customerId) {
        this.customerId = customerId;
    }
    
    
    @GET
    @Path("{customerId}")
    public List<Account> getAccounts(@PathParam("customerId") int cId) {
        System.out.println("t2");
        AccountService accountService = new AccountService();
        System.out.print("22222222222");
        return accountService.getAllAccounts(cId);
   }
    
}
