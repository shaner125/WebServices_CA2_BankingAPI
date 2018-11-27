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
@Path("/weather")
public class ProxyWeather {

@GET
@Path("/{param}")
public Response GetWeatherForecast(@PathParam("param") String city) {
    String apiID = "1af8208c3624c7ec4e82b3f67e891c80";
    String URL = "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&mode=json&appid="+apiID;
    Client c = ClientBuilder.newClient();
    Response r = c.target(URL).request().get();
    return r;
}
}
