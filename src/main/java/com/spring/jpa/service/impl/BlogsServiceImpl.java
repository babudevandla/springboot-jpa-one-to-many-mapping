package com.spring.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.model.Blog;
import com.spring.jpa.repository.BlogsRepository;
import com.spring.jpa.service.BlogsService;

@Service
@Transactional
public class BlogsServiceImpl implements BlogsService {

	@Autowired
	BlogsRepository blogsRepository;

	@Override
	public List<Blog> findAll() {
		return blogsRepository.findAll();
	}

	@Override
	public Blog save(Blog blog) {
		// TODO Auto-generated method stub
		return blogsRepository.save(blog);
	}

	@Override
	public Optional<Blog> findById(Long Id) {
		// TODO Auto-generated method stub
		return blogsRepository.findById(Id);
	}

	@Override
	public void delete(Blog blog) {
		// TODO Auto-generated method stub
		blogsRepository.delete(blog);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		blogsRepository.deleteAll();
	}
}
