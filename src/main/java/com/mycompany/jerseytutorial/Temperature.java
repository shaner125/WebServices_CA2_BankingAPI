/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author MTova-Izquierdo
 */
@Path("/Converter")
public class Temperature {
    
    @GET
    @Path("/Celcius/{param}")
    public Response sayHelloWorldC(@PathParam("param") int grades) {
        String output = grades + "C to F =" + String.valueOf(grades*9/5+32) + "!";
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/Farenheit/{param}")
    public Response sayHelloWorldF(@PathParam("param") int grades) {
        String output = grades + "F to C =" + String.valueOf((grades-32)*5/9) + "!";
        return Response.status(200).entity(output).build();
    }
    
/* Using QueryParam like http://localhost:49000/api/Converter?Celcius=67 */
    
    @GET
    public Response sayHelloWorld(@QueryParam("Celcius") int cgrades, 
                                  @QueryParam("Farenheit") int fgrades) {
        String output = "Undefined conversion";
        if (cgrades > 0) {
            output = cgrades + "C to F =" + String.valueOf(cgrades*9/5+32) + "!";
        }        
        if (fgrades > 0) {
            output = fgrades + "F to C =" + String.valueOf((fgrades-32)*5/9) + "!";
        }
        return Response.status(200).entity(output).build();
    }
        
}