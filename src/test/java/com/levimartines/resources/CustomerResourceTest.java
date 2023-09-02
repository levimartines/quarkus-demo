package com.levimartines.resources;

import com.levimartines.models.Car;
import com.levimartines.models.Customer;
import com.levimartines.stubs.CarStub;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CustomerResourceTest extends BaseResourceTest {

	@Test
	void shouldCreateWhenInputIsValid() {
		Customer customer = createTestCustomer();
		Assertions.assertNotNull(customer.id);
		Assertions.assertNotNull(customer.getCars().get(0).id);
	}

	@Test
	void shouldAddCarWhenPayloadIsValid() {
		Customer customer = createTestCustomer();
		Car newCar = CarStub.testOldCar();
		given()
			.header("Content-type", "application/json")
			.and().body(newCar).when().put("/customers/" + customer.id + "/cars")
			.then().statusCode(204);
	}

	@Disabled
	@Test
	void shouldRemoveCar() {
		Customer customer = createTestCustomer();
		Car customerCar = customer.getCars().get(0);
		given().when().delete("/customers/" + customer.id + "/cars/" + customerCar.id)
			.then().statusCode(204);
	}

}