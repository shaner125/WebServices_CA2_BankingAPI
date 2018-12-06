/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;
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
@Path("/transaction")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource{

    private TransactionService transactionService = new TransactionService();
       
    
    @GET
	public List<Transaction> getTransactions(@PathParam("customerId") int cid, @PathParam("accountId") int aid) {
    	System.out.println("Getting all transactions for customer :"+cid+" in account:"+aid);
        return transactionService.getAllTransactions(cid, aid);
	}
    
    
        //POST method for making a transaction, utilizes previous path params and accepts further query params to identify lodgement, withdrawal,
        // transfer and transfer recipient ID.
        //e.g localhost:49000/api/customers/1/accounts/11111/transaction?type=lodge
        //e.g localhost:49000/api/customers/1/accounts/11111/transaction?type=withdraw
        //e.g localhost:49000/api/customers/1/accounts/11111/transaction?type=transfer&recipientCustId=2&recipientAccountId=22222
        @POST
        public Transaction makeTransaction(@PathParam("customerId") int cid,
                                           @PathParam("accountId") int aid, 
                                           @QueryParam("type") String type,   
                                           @QueryParam("recipientCustId") int recipientCustId,
                                           @QueryParam("recipientAccountId") int recipientAccId,
                                           Transaction t) {
            System.out.println("making transaction...index : "+cid+" , accountIndex: "+aid+" ,"+type);
       if (null != type) switch (type) {
            case "lodge":
                System.out.println("lodging");
                return transactionService.makeLodgement(cid, aid, t);
            case "withdraw":
                System.out.println("withdrawing");
                return transactionService.makeWithdrawal(cid, aid, t);
            case "transfer":
                System.out.println("transferring");
                return transactionService.makeTransfer(cid, aid, recipientCustId,recipientAccId,t);
            default:
                break;
        }
       return t;
   } 

    
}
