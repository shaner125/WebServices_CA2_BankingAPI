/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;

import com.mycompany.jerseytutorial.model.Message;
import com.mycompany.jerseytutorial.services.MessageService;
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
 * @author manueltovaizquierdo
 */
@Path("/messages")
//@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    
    MessageService messageService = new MessageService();
  
    /*
    If using POSTMAN as client, remember setting a Header 
    "Accept:application/json" for retrieving JSON format
    "Accept:application/xml" for retrieving XML format
    */    
//    @GET
//    public List<Message> getMessages() {
//        return messageService.getAllMessages();
//    }
    
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") int id) {
        return messageService.getMessage(id);
    }
    
    /*
    * When using POSTMAN remember to include in Headers: Content-type : application/json
    * and include in the body of the request in RAW format the object in JSON notation
    */
    @POST
    public Message postMessage(Message m) {
	return messageService.createMessage(m);
    }
    
    /*
     * Search for a Message 
     * GET http://localhost:49000/api/messages?author=Jack&message=helloworld
     * either by @QueryParam message content
     * or by @QueryParam author
     */
    @GET
    public List<Message> getFilteredMessages(@QueryParam("message") String message, @QueryParam("author") String author) {
        if ((message != null) || (author != null)) {
                     return messageService.getSearchMessages(message, author);
        }
        return messageService.getAllMessages();
    } 
}
