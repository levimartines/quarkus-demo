package com.levimartines.resources;

import com.levimartines.dtos.CarDTO;
import com.levimartines.models.Customer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CarResourceTest extends BaseResourceTest {

	@Test
	void shouldFindByPlate() {
		Customer customer = createTestCustomer();
		String carPlate = customer.getCars().get(0).getPlate();
		CarDTO car = given().when().get("/cars?plate=" + carPlate)
			.then().statusCode(200)
			.and().extract().as(CarDTO.class);
		Assertions.assertNotNull(car);
		Assertions.assertEquals(customer.getName(), car.getCustomer().getName());
	}

}