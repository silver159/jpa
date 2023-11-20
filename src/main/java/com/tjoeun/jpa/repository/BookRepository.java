package com.tjoeun.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjoeun.jpa.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
}
