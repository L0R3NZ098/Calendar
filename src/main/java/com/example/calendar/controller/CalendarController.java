package com.example.calendar.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.calendar.model.Calendar;
import com.example.calendar.service.CalendarService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
	
	@Autowired
	private CalendarService serv;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Calendar>> getAll() {
		List<Calendar> all = serv.getAllCalendar();
		return ResponseEntity.ok().body(all);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Calendar> getById(@PathVariable(value = "id") Long id) {
		Calendar one = serv.getCalendarById(id);
		return ResponseEntity.ok().body(one);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Calendar> createUser(@RequestBody Calendar calendar) {
		Calendar create = serv.createCalendar(calendar);
		return ResponseEntity.ok().body(create);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Calendar> updateCalendar(@PathVariable(value = "id") Long id, @RequestBody Calendar calendar) {
		Calendar update = serv.updateCalendar(id, calendar);
		return ResponseEntity.ok().body(update);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCalendar(@PathVariable(value = "id") Long id) {
		serv.deleteCalendar(id);
		return ResponseEntity.ok().build();
	}
	
}
