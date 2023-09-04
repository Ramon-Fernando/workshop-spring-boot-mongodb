package com.ramonfernando.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramonfernando.workshopmongo.domain.Post;
import com.ramonfernando.workshopmongo.repository.PostRepository;
import com.ramonfernando.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post user = repo.findById(id).get();
		if (user == null) {
			throw new ObjectNotFoundException("Object not found");
		}
		return user;
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
}
