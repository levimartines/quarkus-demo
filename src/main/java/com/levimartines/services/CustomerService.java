package com.levimartines.services;

import com.levimartines.models.Car;
import com.levimartines.models.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CustomerService {

	@Transactional
	public Customer save(Customer customer) {
		customer.getCars().forEach(car -> car.setCustomer(customer));
		customer.persist();
		return customer;
	}

	@Transactional
	public void addCar(String id, Car car) {
		Customer customer = Customer.findById(id);
		customer.addCar(car);
		customer.persist();
	}

	public List<Customer> findAll() {
		return Customer.findAll().list();
	}
}
