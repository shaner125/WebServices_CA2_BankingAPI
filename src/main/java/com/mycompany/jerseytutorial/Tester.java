/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author MTova-Izquierdo
 */
@Path("/hello")
public class Tester {
    
    @GET
    @Path("/{param}")
    public Response sayHelloWorld(@PathParam("param") String message) {
        String output = "Hello " + message + "!!!";
        return Response.status(200).entity(output).build();
    } 
}
