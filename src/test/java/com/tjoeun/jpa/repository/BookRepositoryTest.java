package com.tjoeun.jpa.repository;

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
//		book.setAuthor("홍길동");
		book.setCategory("애니메이션");
		book.setAuthorId(1L);
		book.setPublisherId(1L);
//		book.setCreateAt(LocalDateTime.now());
//		book.setUpdateAt(LocalDateTime.now());
//		bookRepository.save(book);
		// save() 메소드는 Entity에 저장하고 저장한 데이터를 리턴한다.
		System.out.println("Book entity에 저장한 데이터: "+ bookRepository.save(book));
		
		bookRepository.findAll().forEach(System.out::println);
		
	}
	
}
