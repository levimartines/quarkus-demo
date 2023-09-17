package com.levimartines.mappers;

import com.levimartines.dtos.ServiceDTO;
import com.levimartines.models.Service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ServiceMapper {

	@Inject
	ServiceItemMapper itemMapper;

	public ServiceDTO toDTO(Service service) {
		ServiceDTO dto = new ServiceDTO();
		dto.setId(service.id);
		dto.setDate(service.getDate());
		dto.setItems(service.getServiceItems().stream().map(item -> itemMapper.toDTO(item)).toList());
		return dto;
	}

}
