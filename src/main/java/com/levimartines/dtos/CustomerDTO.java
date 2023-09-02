package com.levimartines.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDTO {

	private String name;
	private String email;
	private String phone;
	private String address;

}
