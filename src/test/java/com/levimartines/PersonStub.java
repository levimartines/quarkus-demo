package com.levimartines;

import com.levimartines.models.Person;
import com.levimartines.models.Status;

import java.time.LocalDate;

public class PersonStub {

	public static Person testPerson() {
		Person person = new Person();
		person.setName("Test Tester");
		person.setBirth(LocalDate.of(1995, 12, 25));
		person.setEmail("t.t@test.com");
		person.setStatus(Status.Alive);
		return person;
	}
}
