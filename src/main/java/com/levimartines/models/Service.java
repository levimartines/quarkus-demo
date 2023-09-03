package com.levimartines.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
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
@Table(name = "service")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE service SET deleted=true WHERE id=?")
public class Service extends PanacheEntity {

	private String name;
	private Double value;
	private boolean deleted;

}
