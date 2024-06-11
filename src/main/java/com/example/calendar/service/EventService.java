package com.example.calendar.service;

import java.util.List;
import com.example.calendar.model.Event;

public interface EventService {
	
	public List<Event> getAllEvent();
	public Event getEventById(Long id);
	public Event createEvent(Event event);
	public Event updateEvent(Long id, Event event);
	public void deleteEvent(Long id);
	public List<Event> findByDay(Integer day);
	public List<Event> findByMonth(Integer month);
	public List<Event> findByYear(Integer year);
	
}
