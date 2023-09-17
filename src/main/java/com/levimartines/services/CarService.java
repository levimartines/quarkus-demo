package com.levimartines.services;

import com.levimartines.dtos.CarDTO;
import com.levimartines.dtos.ServiceDTO;
import com.levimartines.dtos.ServiceItemDTO;
import com.levimartines.mappers.CarMapper;
import com.levimartines.mappers.ServiceItemMapper;
import com.levimartines.mappers.ServiceMapper;
import com.levimartines.models.Car;
import com.levimartines.models.Service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CarService {

	@Inject
	CarMapper mapper;
	@Inject
	ServiceMapper serviceMapper;
	@Inject
	ServiceItemMapper itemMapper;

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

	@Transactional
	public ServiceDTO addService(Long id, List<ServiceItemDTO> items) {
		Car car = Car.findById(id);

		Service service = new Service();
		service.setCar(car);
		service.setServiceItems(items.stream().map(item -> itemMapper.toEntity(item)).toList());
		service.getServiceItems().forEach(item -> item.setService(service));
		service.persist();

		return serviceMapper.toDTO(service);
	}
}
