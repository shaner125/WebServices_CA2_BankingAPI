/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;
import com.mycompany.jerseytutorial.model.Transaction;
import com.mycompany.jerseytutorial.services.TransactionService;
import javax.ws.rs.Consumes;
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
       
        @POST
        public Transaction makeTransaction(@PathParam("customerId") int cid,
                                           @PathParam("accountId") int aid, 
                                           @QueryParam("type") String type,   
                                           @QueryParam("recipientId") int recipientId,
                                           Transaction t) {
            System.out.println("making transaction...index : "+cid+" , accountIndex: "+aid+" ,"+type);
       if (null != type) switch (type) {
            case "lodge":
                System.out.println("lodging");
                return transactionService.makeLodgement(cid, aid, t);
            case "withdraw":
                System.out.println("withdrawing");
                return transactionService.makeWithdrawel(cid, aid, t);
            case "transfer":
                System.out.println("transferring");
                return transactionService.makeTransfer(cid, aid, recipientId,t);
            default:
                break;
        }
       return t;
   } 

    
}
