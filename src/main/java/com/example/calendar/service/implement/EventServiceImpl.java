package com.example.calendar.service.implement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.calendar.model.Event;
import com.example.calendar.repository.EventRepository;
import com.example.calendar.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository repo;

	@Override
	public List<Event> getAllEvent() {
		List<Event> all = repo.findAll();
		return all;
	}

	@Override
	public Event getEventById(Long id) {
		Optional<Event> one = repo.findById(id);
		if (one.isPresent()) {
			return one.get();
		} else {
			return null;
		}
	}

	@Override
	public Event createEvent(Event event) {
		Event create = repo.save(event);
		return create;
	}

	@Override
	public Event updateEvent(Long id, Event event) {
		Event update = this.getEventById(id);
		BeanUtils.copyProperties(event, update, "id");
		repo.save(update);
		return update;
	}

	@Override
	public void deleteEvent(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Event> findByDay(Integer day) {
		List<Event> byDay = repo.findByDay(day);
		return byDay;
	}
	
	@Override
	public List<Event> findByMonth(Integer month) {
		List<Event> byMonth = repo.findByMonth(month);
		return byMonth;
	}
	
	@Override
	public List<Event> findByYear(Integer year) {
		List<Event> byYear = repo.findByYear(year);
		return byYear;
	}
	
	@Override
	public List<Event> repeatEvent(LocalDateTime n, Event event) {
		List<Event> repeat = new ArrayList<Event>();
		while (event.getDataFine().isBefore(n)) { 
			Event prova = new Event();
			prova.setTitolo(event.getTitolo());
			prova.setDataInizio(event.getDataInizio());
			prova.setDataFine(event.getDataFine());
			prova.setCalendar(event.getCalendar());
			event.setDataInizio(event.getDataInizio().plusDays(1));
			event.setDataFine(event.getDataFine().plusDays(1));
			repeat.add(prova);
		}
		repo.saveAll(repeat);
		return repeat;
	}
	
}
