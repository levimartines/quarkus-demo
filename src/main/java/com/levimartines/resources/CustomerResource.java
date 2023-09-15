package com.levimartines.resources;

import com.levimartines.dtos.CustomerDTO;
import com.levimartines.models.Customer;
import com.levimartines.services.CustomerService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class CustomerResource {

	private static final Logger LOG = Logger.getLogger(CustomerResource.class);

	@Inject
	CustomerService service;

	@GET
	public List<CustomerDTO> findAll() {
		return service.findAll();
	}

	@POST
	public Response save(Customer customer) {
		customer = service.save(customer);
		return Response.created(URI.create("/customers/" + customer.id)).entity(customer).build();
	}

}
