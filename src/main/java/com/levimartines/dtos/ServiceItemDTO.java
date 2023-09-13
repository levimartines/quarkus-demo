package com.levimartines.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ServiceItemDTO {
	private String name;
	private Double value;
}
