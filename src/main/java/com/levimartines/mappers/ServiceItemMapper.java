package com.levimartines.mappers;

import com.levimartines.dtos.ServiceItemDTO;
import com.levimartines.models.ServiceItem;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceItemMapper {

	public ServiceItemDTO toDTO(ServiceItem item) {
		ServiceItemDTO dto = new ServiceItemDTO();
		dto.setName(item.getName());
		dto.setValue(item.getValue());
		return dto;
	}

	public ServiceItem toEntity(ServiceItemDTO dto) {
		ServiceItem item = new ServiceItem();
		item.setName(dto.getName());
		item.setValue(dto.getValue());
		return item;
	}
}
