package com.example.calendar.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.calendar.model.Calendar;
import com.example.calendar.repository.CalendarRepository;
import com.example.calendar.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService{
	
	@Autowired 
	private CalendarRepository repo;
	
	@Override
	public List<Calendar> getAllCalendar() {
		List<Calendar> all = repo.findAll();
		return all;
	}

	@Override
	public Calendar getCalendarById(Long id) {
		Optional<Calendar> one = repo.findById(id);
		if (one.isPresent()) {
			return one.get();
		} else {
			return null;
		}
	}

	@Override
	public Calendar createCalendar(Calendar calendar) {
		Calendar create = repo.save(calendar);
		return create;
	}

	@Override
	public Calendar updateCalendar(Long id, Calendar calendar) {
		Calendar update = this.getCalendarById(id);
		BeanUtils.copyProperties(calendar, update, "id");
		repo.save(calendar);
		return update;
	}

	@Override
	public void deleteCalendar(Long id) {
		repo.deleteById(id);
	}

}
