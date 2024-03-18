package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;

import com.spring.jpa.model.Blog;

public interface BlogsService {

	
	Blog save(Blog blog);

	Optional<Blog> findById(Long Id);

	void delete(Blog blog);

	List<Blog> findAll();

	void deleteAll();

}
