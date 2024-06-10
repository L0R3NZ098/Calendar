package com.example.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.calendar.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
