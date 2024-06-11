package com.example.calendar.service;

import java.util.List;
import com.example.calendar.model.Event;

public interface EventService {
	
	List<Event> getAllEvent();
	Event getEventById(Long id);
	Event createEvent(Event event);
	Event updateEvent(Long id, Event event);
	void deleteEvent(Long id);
	
}
