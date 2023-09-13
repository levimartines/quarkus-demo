package com.levimartines.dtos;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ServiceDTO {
	private Long id;
	private LocalDate date;
	private List<ServiceItemDTO> items = new ArrayList<>();
}
