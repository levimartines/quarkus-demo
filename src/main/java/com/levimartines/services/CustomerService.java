package com.levimartines.services;

import com.levimartines.dtos.CustomerDTO;
import com.levimartines.mappers.CustomerMapper;
import com.levimartines.models.Car;
import com.levimartines.models.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CustomerService {

	@Inject
	CustomerMapper mapper;

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

	public List<CustomerDTO> findAll() {
		return Customer.streamAll()
			.map(c -> mapper.toDTO((Customer) c)).toList();
	}
}
