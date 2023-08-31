package com.ramonfernando.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramonfernando.workshopmongo.domain.User;
import com.ramonfernando.workshopmongo.repository.UserRepository;
import com.ramonfernando.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).get();
		if (user == null) {
			throw new ObjectNotFoundException("Object not found");
		}
		return user;
	}
	
}
