package com.levimartines.services;

import com.levimartines.dtos.CarDTO;
import com.levimartines.mappers.CarMapper;
import com.levimartines.models.Car;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CarService {

	@Inject
	CarMapper mapper;

	public CarDTO findByPlate(String plate) {
		Car car = Car.findByPlate(plate);
		return mapper.toDTO(car);
	}
}
