package com.booleanuk.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String first_name;

	@Column
	private String last_name;

	@Column
	private String email;

	@Column
	private boolean alive;

	@OneToMany(mappedBy = "author")
	@JsonIgnoreProperties(value = {"author","publisher"})
	private List<Book> books;


	public Author(int id) {
		this.id = id;
	}

	public Author(String first_name, String last_name, String email, boolean alive) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.alive = alive;
	}
}
