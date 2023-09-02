package com.levimartines.resources;

import com.levimartines.dtos.CarDTO;
import com.levimartines.services.CarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

	@Inject
	CarService service;

	@GET
	public CarDTO findByPlate(@RestQuery String plate) {
		return service.findByPlate(plate);
	}
}
