package com.levimartines.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car extends PanacheEntity {

	@NotNull
	private String model;
	private String color;
	private String comments;
	private String plate;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	private List<Service> services = new ArrayList<>();

	public static Car findByPlate(String plate) {
		String query = "SELECT c FROM Car c INNER JOIN FETCH c.customer WHERE UPPER(c.plate) = ?1";
		return find(query, plate.toUpperCase()).firstResult();
	}

}
