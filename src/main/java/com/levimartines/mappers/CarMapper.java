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
		if (car == null) return null;
		CarDTO dto = new CarDTO();
		dto.setId(car.id);
		dto.setComments(car.getComments());
		dto.setPlate(car.getPlate());
		dto.setName(car.getName());
		dto.setCustomer(customerMapper.toDTO(car.getCustomer()));
		return dto;
	}
}
