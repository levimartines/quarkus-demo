package com.levimartines.services;

import com.levimartines.dtos.CarDTO;
import com.levimartines.mappers.CarMapper;
import com.levimartines.models.Car;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CarService {

	@Inject
	CarMapper mapper;

	public CarDTO findById(Long id) {
		Car car = Car.findById(id);
		return mapper.toDTO(car);
	}

	public CarDTO findByPlate(String plate) {
		Car car = Car.findByPlate(plate);
		return mapper.toDTO(car);
	}

	@Transactional
	public CarDTO save(CarDTO dto) {
		Car car = mapper.toEntity(dto);
		car.persist();
		return mapper.toDTO(car);
	}

	public CarDTO find(Long id, String plate) {
		if (id == null) {
			return findByPlate(plate);
		}
		return findById(id);
	}
}
