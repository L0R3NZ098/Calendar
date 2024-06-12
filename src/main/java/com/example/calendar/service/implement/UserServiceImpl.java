package com.example.calendar.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.calendar.model.User;
import com.example.calendar.repository.UserRepository;
import com.example.calendar.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public List<User> getAllUser() {
		List<User> all = repo.findAll();
		return all;
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> one = repo.findById(id);
		if (one.isPresent()) {
			return one.get();
		} else {
			return null;
		}
	}

	@Override
	public User createUser(User user) {
		User create = repo.save(user);
		return create;
	}

	@Override
	public User updateUser(Long id, User user) {
		User update = this.getUserById(id);
		BeanUtils.copyProperties(user, update);
		repo.save(update);
		return update;
	}

	@Override
	public void deleteUser(Long id) {
		repo.deleteById(id);
	}

}
