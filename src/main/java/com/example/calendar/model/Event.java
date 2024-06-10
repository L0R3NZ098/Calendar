package com.example.calendar.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nonnull
	private String titolo;
	
	@Nonnull
	private LocalDateTime dataInizio;
	
	@Nonnull
	private LocalDateTime dataFine;
	
	@ManyToOne
	@JoinColumn(name = "calendar_id")
	@Nonnull
	@JsonBackReference
	private Calendar calendar;

	public Event(Long id, String titolo, LocalDateTime dataInizio, LocalDateTime dataFine, Calendar calendar) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.calendar = calendar;
	}

	public Event() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
}
