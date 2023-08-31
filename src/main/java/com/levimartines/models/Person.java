package com.levimartines.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Page;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE person SET deleted=true WHERE id=?")
public class Person extends PanacheEntity {
	private String name;
	private String email;
	private LocalDate birth;
	private Status status;
	private boolean deleted;

	public static Person findByName(String name) {
		return find("UPPER(name)", name.toUpperCase()).firstResult();
	}

	public static Page findPage() {
		return null;
	}

	public static List<Person> findAlive(){
		return list("status", Status.Alive);
	}

}
