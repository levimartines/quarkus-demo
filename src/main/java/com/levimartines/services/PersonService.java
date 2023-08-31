package com.levimartines.services;

import com.levimartines.models.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;


@ApplicationScoped
public class PersonService {

	private static final Logger log = Logger.getLogger(PersonService.class);

	public Person save(Person person) {
		log.info(String.format("Saving person %s", person.getName()));
		person.persist();
		return person;
	}

	public Person findByName(String name) {
		return Person.findByName(name);
	}

	@Transactional
	public void deleteById(Long id) {
		Person.findById(id).delete();
	}
}
