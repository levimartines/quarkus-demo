package com.levimartines.resources;

import com.levimartines.dtos.CarDTO;
import com.levimartines.dtos.ServiceDTO;
import com.levimartines.dtos.ServiceItemDTO;
import com.levimartines.services.CarService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
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

	@POST
	@Path("/{id}/services")
	public ServiceDTO createService(@PathParam("id") Long id, List<ServiceItemDTO> items) {
		return service.addService(id, items);
	}

}
