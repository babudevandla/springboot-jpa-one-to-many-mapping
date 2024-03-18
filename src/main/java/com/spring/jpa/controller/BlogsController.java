package com.spring.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.exception.ResourceNotFoundException;
import com.spring.jpa.model.Blog;
import com.spring.jpa.service.BlogsService;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogsController {

	@Autowired
	private BlogsService blogsService;

	@GetMapping
	public List<Blog> getUsers() {
		return blogsService.findAll();
	}
	
	@PostMapping
	public Blog saveBlog(@RequestBody Blog owner) {
		System.out.println("Owner save called...");
		Blog blog = blogsService.save(owner);
		System.out.println("Saved!!!");

		return blog;
	}

	@GetMapping("/{id}")
	public String getBlogs(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
		System.out.println("Owner get called...");
		Blog blog = blogsService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Blog not found :: " + id));
		System.out.println("\nBlog details with Comments :: \n" + blog);
		System.out.println("\nList of Blogs :: \n" + blog.getComments());
		System.out.println("\nDone!!!");

		return "Blogs fetched...";
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Blog> updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody Blog blogDetails)
			throws ResourceNotFoundException {
		Blog blog = blogsService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Blog not found :: " + id));
		final Blog updatedUser = blogsService.save(blog);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteBlogById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Blog blog = blogsService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Blog not found :: " + id));

		blogsService.delete(blog);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping
	public Map<String, Boolean> deleteAll() throws ResourceNotFoundException {
		
		blogsService.deleteAll();
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}