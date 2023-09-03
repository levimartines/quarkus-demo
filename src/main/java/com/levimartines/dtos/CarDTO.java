package com.levimartines.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarDTO {
	private Long id;
	private String name;
	private String comments;
	private String plate;
	private CustomerDTO customer;
}
