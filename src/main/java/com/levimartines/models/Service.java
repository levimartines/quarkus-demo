package com.levimartines.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "services")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE services SET deleted=true WHERE id=?")
public class Service extends PanacheEntity {

	@ManyToOne
	@JoinColumn(name = "car_id")
	@NotNull
	private Car car;

	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
	private List<ServiceItem> serviceItems = new ArrayList<>();
	private LocalDate date = LocalDate.now();

	private boolean deleted;

}
