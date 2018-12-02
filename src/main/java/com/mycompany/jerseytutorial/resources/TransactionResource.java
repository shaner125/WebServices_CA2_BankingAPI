/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;
import com.mycompany.jerseytutorial.model.Customer;
import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Transaction;
import com.mycompany.jerseytutorial.services.TransactionService;
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
@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource{

    private TransactionService transactionService = new TransactionService();
       
        @POST
        @Path("/transaction")
        public Transaction makeTransaction(@PathParam("customerId") int cid,
                                           @PathParam("accountId") int aid, 
                                           @QueryParam("lodge") String lodge,   
                                           @QueryParam("withdraw") String withdraw, 
                                           @QueryParam("transfer") String transfer,
                                           @QueryParam("recipientId") int recipientId,
                                           Transaction t) {
       if ((lodge != null)) {
       return transactionService.makeLodgement(cid, aid, t);
       }
       else if ((withdraw != null)) {
       return transactionService.makeWithdrawel(cid, aid, t);
       }
       else if ((transfer != null)){
       return transactionService.makeTransfer(cid, aid, recipientId,t);
       }
       return t;
   } 

    
}
