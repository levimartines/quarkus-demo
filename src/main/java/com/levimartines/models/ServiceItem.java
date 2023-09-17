package com.levimartines.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "service_items")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE service_items SET deleted=true WHERE id=?")
public class ServiceItem extends PanacheEntity {

	private String name;
	private Double value;
	private boolean deleted;
	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false, insertable = false, updatable = false)
	private Service service;
}
