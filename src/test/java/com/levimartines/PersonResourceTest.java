package com.levimartines;

import com.levimartines.models.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PersonResourceTest {

	@Test
	public void findByFilter() {
		Person testPerson = save(PersonStub.testPerson());
		Person person = given()
				.header("Content-type", "application/json")
				.when().get("/persons?name=" + testPerson.getName())
				.then()
				.statusCode(200)
				.extract().body().as(Person.class);
		Assertions.assertEquals(testPerson.getName(), person.getName());
	}

	@Test
	public void delete() {
		given()
				.header("Content-type", "application/json")
				.when().delete("/persons?id=1")
				.then()
				.statusCode(204);
	}



	public Person save(Person person) {
		return given()
				.header("Content-type", "application/json")
				.and().body(person).when().post("/persons")
				.then().statusCode(201)
				.extract().body().as(Person.class);
	}

}