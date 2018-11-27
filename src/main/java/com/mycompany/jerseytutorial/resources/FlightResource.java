/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.jerseytutorial.resources;

import com.mycompany.jerseytutorial.model.Flight;
import com.mycompany.jerseytutorial.model.Passenger;
import com.mycompany.jerseytutorial.services.FlightService;
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
@Path("/flights")
//@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FlightResource {
   
   FlightService FlightService = new FlightService();
 
   /*
   If using POSTMAN as client, remember setting a Header 
   "Accept:application/json" for retrieving JSON format
   "Accept:application/xml" for retrieving XML format
   */    
//   @GET
//   public List<Flight> getFlights() {
//       return FlightService.getAllFlights();
//   }
   
   @GET
   @Path("/{flight}")
   public Flight getFlight(@PathParam("flight") int id) {
       return FlightService.getFlight(id);
   }
   
   @GET
   @Path("/{flight}/passengers/{passport}")
   public Passenger getFlight(@PathParam("flight") int id, @PathParam("passport") String passportNo) {
       return FlightService.getPassengerInFlight(id, passportNo);
   }
   
   /*
   * When using POSTMAN remember to include in Headers: Content-type : application/json
   * and include in the body of the request in RAW format the object in JSON notation
   */
   @POST
   public Flight postFlight(Flight m) {
	return FlightService.createFlight(m);
   }
   
   /*
    * Search for a Flight 
    * GET http://localhost:49000/api/Flights?author=Jack&Flight=helloworld
    * either by @QueryParam Flight content
    * or by @QueryParam author
    */
   @GET
   public List<Flight> getFilteredFlights(@QueryParam("city") String city, 
		   								  @QueryParam("airline") String airline, 
		   								  @QueryParam("time") String time,
		   								  @QueryParam("start") int start,
		   								  @QueryParam("size") int size) {
       if ((city != null) || (airline != null) || (time != null)) {
                    return FlightService.getSearchFlights(city, airline, time);
       }
       if (start >= 1 && size > 0 ) {
    	   			return FlightService.getAllFlightsPaginated(start, size);
       }
       return FlightService.getAllFlights();
   } 
}

