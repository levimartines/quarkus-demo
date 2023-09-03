package com.levimartines.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car extends PanacheEntity {

	@NotNull
	private String name;
	private String comments;
	private String plate;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	public static Car findByPlate(String plate) {
		String query = "SELECT c FROM Car c INNER JOIN FETCH c.customer WHERE UPPER(c.plate) = ?1";
		return find(query, plate.toUpperCase()).firstResult();
	}

}
