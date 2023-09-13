package com.levimartines.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "customers")
public class Customer extends PanacheEntity {

	@NotNull
	private String name;
	private String email;
	@NotNull
	private String phone;
	@NotNull
	private String address;
	private String comments;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	private List<Car> cars = new ArrayList<>();

	public void addCar(Car car) {
		car.setCustomer(this);
		cars.add(car);
	}

}
