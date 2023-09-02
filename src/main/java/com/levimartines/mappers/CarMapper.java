package com.levimartines.mappers;

import com.levimartines.dtos.CarDTO;
import com.levimartines.models.Car;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CarMapper {

	@Inject
	CustomerMapper customerMapper;

	public CarDTO toDTO(Car car) {
		CarDTO dto = new CarDTO();
		dto.setComments(car.getComments());
		dto.setPlate(car.getPlate());
		dto.setName(car.getName());
		dto.setCustomerDTO(customerMapper.toDTO(car.getCustomer()));
		return dto;
	}

	;
}
