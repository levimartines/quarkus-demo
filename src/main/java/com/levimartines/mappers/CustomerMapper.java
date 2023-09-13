package com.levimartines.mappers;

import com.levimartines.dtos.CustomerDTO;
import com.levimartines.models.Customer;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerMapper {

	public CustomerDTO toDTO(Customer customer) {
		CustomerDTO dto = new CustomerDTO();
		dto.setId(customer.id);
		dto.setPhone(customer.getPhone());
		dto.setEmail(customer.getEmail());
		dto.setName(customer.getName());
		dto.setAddress(customer.getAddress());
		return dto;
	}

	public Customer toEntity(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.id = dto.getId();
		customer.setPhone(dto.getPhone());
		customer.setEmail(dto.getEmail());
		customer.setName(dto.getName());
		customer.setAddress(dto.getAddress());
		return customer;
	}
}
