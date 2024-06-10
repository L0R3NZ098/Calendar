package com.example.calendar.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "calendar")
public class Calendar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nonnull
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@Nonnull
	@JsonBackReference
	private User user;
	
	@OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Event> eventi;

	public Calendar(Long id, String nome, User user, List<Event> eventi) {
		super();
		this.id = id;
		this.nome = nome;
		this.user = user;
		this.eventi = eventi;
	}

	public Calendar() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Event> getEventi() {
		return eventi;
	}

	public void setEventi(List<Event> eventi) {
		this.eventi = eventi;
	}
	
}
