package com.levimartines.mappers;

import com.levimartines.dtos.CustomerDTO;
import com.levimartines.models.Customer;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerMapper {

	public CustomerDTO toDTO(Customer customer) {
		CustomerDTO dto = new CustomerDTO();
		dto.setPhone(customer.getPhone());
		dto.setEmail(customer.getEmail());
		dto.setName(customer.getName());
		dto.setAddress(customer.getAddress());
		return dto;
	}

	;
}
