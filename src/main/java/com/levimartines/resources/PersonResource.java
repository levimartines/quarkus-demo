package com.levimartines.resources;

import com.levimartines.models.Person;
import com.levimartines.services.PersonService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

	@Inject
	PersonService service;

	@GET
	public Person findByName(@RestQuery String name) {
		return service.findByName(name);
	}

	@POST
	@Transactional
	public Response save(Person person) {
		person = service.save(person);
		return Response.status(201).entity(person).build();
	}

	@DELETE
	public void deleteById(@RestQuery Long id) {
		service.deleteById(id);
	}
}
