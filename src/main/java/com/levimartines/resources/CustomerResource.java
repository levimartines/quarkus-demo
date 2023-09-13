package com.levimartines.resources;

import com.levimartines.models.Car;
import com.levimartines.models.Customer;
import com.levimartines.services.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

import java.net.URI;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

	@Inject
	CustomerService service;

	@GET
	public List<Customer> findAll() {
		return service.findAll();
	}

	@POST
	public Response save(Customer customer) {
		customer = service.save(customer);
		return Response.created(URI.create("/customers/" + customer.id)).entity(customer).build();
	}

	@PUT
	@Path("/{id}/cars")
	public void addCar(@RestPath String id, Car car) {
		service.addCar(id, car);
	}
}
