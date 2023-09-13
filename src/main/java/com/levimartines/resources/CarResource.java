package com.levimartines.resources;

import com.levimartines.dtos.CarDTO;
import com.levimartines.services.CarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

	@Inject
	CarService service;

	@GET
	public CarDTO find(@RestQuery Long id, @RestQuery String plate) {
		return service.find(id, plate);
	}

	@POST
	public CarDTO save(CarDTO car) {
		return service.save(car);
	}

}
