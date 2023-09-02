package com.levimartines.stubs;

import com.levimartines.models.Customer;

public class CustomerStub {

	public static Customer testCustomer() {
		Customer customer = new Customer();
		customer.setName("Test Tester");
		customer.setEmail("t.t@test.com");
		customer.setAddress("R: Jaime Teodoro Franco, 2442. Jd Sao Paulo");
		customer.setComments("veio da lancha");
		customer.setPhone("159999999");
		customer.addCar(CarStub.testCar());
		return customer;
	}
}
