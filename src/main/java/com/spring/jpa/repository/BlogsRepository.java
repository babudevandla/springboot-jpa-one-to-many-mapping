package com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.model.Blog;

@Repository
public interface BlogsRepository extends JpaRepository<Blog, Long> {


	
}
