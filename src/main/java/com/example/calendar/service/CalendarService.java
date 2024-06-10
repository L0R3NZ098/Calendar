package com.example.calendar.service;

import java.util.List;

import com.example.calendar.model.Calendar;

public interface CalendarService {
	
	List<Calendar> getAllCalendar();
	Calendar getCalendarById(Long id);
	Calendar createCalendar(Calendar calendar);
	Calendar updateCalendar(Long id, Calendar calendar);
	void deleteCalendar(Long id);
	
}
