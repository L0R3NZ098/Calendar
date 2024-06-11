package com.example.calendar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.calendar.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Query(value = "SELECT * FROM event where day(data_inizio)=?1", nativeQuery = true)
	public List<Event> findByDay(Integer day);
	
	@Query(value = "SELECT 	* FROM event where month(data_inizio)=?1", nativeQuery = true)
	public List<Event> findByMonth(Integer month);
	
	@Query(value = "SELECT * FROM event where year(data_inizio)=?1", nativeQuery = true)
	public List<Event> findByYear(Integer year);
	
}
