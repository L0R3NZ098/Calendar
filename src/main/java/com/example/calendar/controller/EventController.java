package com.example.calendar.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.calendar.model.Event;
import com.example.calendar.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService serv;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Event>> getAll() {
		List<Event> all = serv.getAllEvent();
		return ResponseEntity.ok().body(all);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Event> getById(@PathVariable(value = "id") Long id) {
		Event one = serv.getEventById(id);
		return ResponseEntity.ok().body(one);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		Event create = serv.createEvent(event);
		return ResponseEntity.ok().body(create);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long id, @RequestBody Event event) {
		Event update = serv.updateEvent(id, event);
		return ResponseEntity.ok().body(update);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEvent(@PathVariable(value = "id") Long id) {
		serv.deleteEvent(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/day")
	public ResponseEntity<List<Event>> getByDay(@RequestParam(value = "day") Integer day) {
		List<Event> byDay = serv.findByDay(day);
		return ResponseEntity.ok().body(byDay);
	}
	
	@GetMapping("/month")
	public ResponseEntity<List<Event>> getByMonth(@RequestParam(value = "month") Integer month) {
		List<Event> byMonth = serv.findByMonth(month);
		return ResponseEntity.ok().body(byMonth);
	}
	
	@GetMapping("/year")
	public ResponseEntity<List<Event>> getByYear(@RequestParam(value = "year") Integer year) {
		List<Event> byYear = serv.findByYear(year);
		return ResponseEntity.ok().body(byYear);
	}
	
	@PostMapping("/repeat")
	public ResponseEntity<List<Event>> repeatEvent(@RequestParam(value = "n") LocalDateTime n, @RequestBody Event event) {
		List<Event> repeat = serv.repeatEvent(n, event);
		return ResponseEntity.ok().body(repeat);
	}
	
}
