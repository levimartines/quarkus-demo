package com.levimartines.resources;

import com.levimartines.models.Service;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ServiceResourceTest extends BaseResourceTest {

	@Test
	void shouldListServices() {
		createTestService();
		Service[] response = given()
			.when().get("/services")
			.then().statusCode(200)
			.and().extract().as(Service[].class);
		Assertions.assertEquals(1, response.length);
	}

	@Test
	void shouldCreateService() {
		Service service = createTestService();
		Assertions.assertNotNull(service);
	}

	@Test
	void shouldEditService() {
		Service service = createTestService();
		Service updatedData = new Service();
		updatedData.setName(service.getName());
		updatedData.setValue(999.99);
		Service response = given()
			.header("Content-type", "application/json")
			.and().body(updatedData).when().put("/services/" + service.id)
			.then().statusCode(204)
			.and().extract().as(Service.class);
		Assertions.assertEquals(updatedData.getValue(), response.getValue());
	}

	@Test
	void shouldDeleteService() {
		Service service = createTestService();
		given().when().delete("/services/" + service.id)
			.then().statusCode(204);
	}

}