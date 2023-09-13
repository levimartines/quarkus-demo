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
		dto.setModel(car.getModel());
		dto.setColor(car.getColor());
		dto.setCustomer(customerMapper.toDTO(car.getCustomer()));
		return dto;
	}

	public Car toEntity(CarDTO dto) {
		if (dto == null) return null;
		Car car = new Car();
		car.id = dto.getId();
		car.setComments(dto.getComments());
		car.setPlate(dto.getPlate().toUpperCase());
		car.setModel(dto.getModel());
		car.setColor(dto.getColor());
		car.setCustomer(customerMapper.toEntity(dto.getCustomer()));
		return car;
	}
}
