package com.levimartines.resources;

import com.levimartines.models.Customer;
import com.levimartines.models.Service;
import com.levimartines.stubs.CustomerStub;
import com.levimartines.stubs.ServiceStubs;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public abstract class BaseResourceTest {

	@Inject
	EntityManager entityManager;

	@BeforeAll
	public static void setup() {
		RestAssured.defaultParser = Parser.JSON;
	}

	@AfterEach
	@Transactional
	public void afterEach() {
		entityManager.createNativeQuery("DELETE FROM service WHERE true").executeUpdate();
		entityManager.createNativeQuery("DELETE FROM car WHERE true").executeUpdate();
		entityManager.createNativeQuery("DELETE FROM customer WHERE true").executeUpdate();
	}

	protected Customer createTestCustomer() {
		Customer customer = CustomerStub.testCustomer();
		return given()
			.header("Content-type", "application/json")
			.and().body(customer).when().post("/customers")
			.then().statusCode(201)
			.and().extract().as(Customer.class);
	}

	protected Service createTestService() {
		Service service = ServiceStubs.testService();
		return given()
			.header("Content-type", "application/json")
			.and().body(service).when().post("/services")
			.then().statusCode(201)
			.and().extract().as(Service.class);
	}

}