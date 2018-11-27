/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author MTova-Izquierdo
 */
@Path("/geocode")
public class ProxyGeocode {

/*
* Use URL to resource like https://maps.googleapis.com/maps/api/geocode/json?address=madrid&key=AIzaSyDmrYrYn8BdUJZ3IM27TwqoZsvoVM7zznE
*/
@GET
@Path("/{param}")
public Response GetGeocodeInfo(@PathParam("param") String city) {
    String URL = "https://maps.googleapis.com/maps/api/geocode/json?address="+city+"&key=AIzaSyDmrYrYn8BdUJZ3IM27TwqoZsvoVM7zznE";
    Client c = ClientBuilder.newClient();
    Response r = c.target(URL).request().get();
    return r;
}
}
