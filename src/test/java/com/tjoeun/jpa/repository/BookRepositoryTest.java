package com.tjoeun.jpa.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.jpa.domain.Book;

@SpringBootTest
class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test // import org.junit.jupiter.api.Test;
	@Transactional // import org.springframework.transaction.annotation.Transactional;
	public void bookTest() {
		
		Book book = new Book();
		book.setTitle("간지나는 springBoot 책");
		book.setAuthor("홍길동");
//		book.setCreateAt(LocalDateTime.now());
//		book.setUpdateAt(LocalDateTime.now());
		bookRepository.save(book);
		bookRepository.findAll().forEach(System.out::println);
		
	}
	
}
