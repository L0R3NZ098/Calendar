package com.example.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.calendar.model.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

}
