package com.tjoeun.jpa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToOne;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.jpa.domain.Book;
import com.tjoeun.jpa.domain.BookReviewInfo;

@SpringBootTest
class BookReviewInfoRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookReviewInfoRepository bookReviewInfoRepository;
	
	@Test
	@Transactional
	public void crudTest() {
		
		BookReviewInfo bookReviewInfo = new BookReviewInfo();
//		bookReviewInfo.setBookId(1L);
		bookReviewInfo.setReviewCount(2);
		bookReviewInfo.setAverageReviewScore(4.5f); // 뒤의 f는 float 타입을 의미한다. 소수 기본값은 Double
		bookReviewInfoRepository.save(bookReviewInfo);
		bookReviewInfoRepository.findAll().forEach(System.out::println);
		
	}
	
	@Test
//	@Transactional // join을 넣어주려면 @Transactional을 주석 처리한다.
	// 양쪽에 foreign key 넣으려면 @Transactional을 주석 처리한다.
	// 한쪽에만 foreign key 넣어준다.
	public void crudTest2() {
		
		// 책 정보 저장
//		Book book = new Book();
//		book.setTitle("드래곤볼");
//		book.setCategory("애니메이션");
//		book.setAuthorId(1L);
//		book.setPublisherId(1L);
//		bookRepository.save(book);
//		bookRepository.findAll().forEach(System.out::println);
		
		// givenBookReviewInfo() 메소드에서 givenBook() 메소드를 실행하므로 주석으로 처리한다. 
//		givenBook();
		
		
		// 리뷰 정보 저장
//		BookReviewInfo bookReviewInfo = new BookReviewInfo();
//		bookReviewInfo.setBookId(1L);
//		bookReviewInfo.setReviewCount(2);
//		bookReviewInfo.setAverageReviewScore(4.5f); 
//		bookReviewInfoRepository.save(bookReviewInfo);
//		bookReviewInfoRepository.findAll().forEach(System.out::println);
		givenBookReviewInfo();
		
		// BookReviewInfo Entity의 bookId 필드에 저장된 id에 해당되는 정보를 book Entity에서 얻어온다.
		
		// RDBMS에서 수행하는 방식
//		System.out.println(bookReviewInfoRepository.findById(1L).orElseThrow(RuntimeException::new).getBookId());
//		Book result = bookRepository.findById(
//					bookReviewInfoRepository.findById(1L).orElseThrow(RuntimeException::new).getBookId()
//				).orElseThrow(RuntimeException::new);
//		System.out.println("result: " + result);
		
		// JPA에서 수행하는 방식 - BookReviewInfo 정보에서 Book 정보를 가져온다.
		System.out.println(bookReviewInfoRepository.findById(1L).orElseThrow(RuntimeException::new).getBook());
		Book result = bookReviewInfoRepository.findById(1L).orElseThrow(RuntimeException::new).getBook();
		System.out.println("result: " + result);
		
		// JPA에서 수행하는 방식 - Book 정보에서 BookReviewInfo 정보를 가져온다.
		System.out.println(bookRepository.findById(1L).orElseThrow(RuntimeException::new));
		System.out.println(bookRepository.findById(1L).orElseThrow(RuntimeException::new).getBookReviewInfo());
		BookReviewInfo result2 = bookRepository.findById(1L).orElseThrow(RuntimeException::new).getBookReviewInfo();
		System.out.println("result2: " + result2);
		
		/*
		 * 내가 생각 한 방법
		List<BookReviewInfo> bookReviewInfos = bookReviewInfoRepository.findAll();
		
		// id 값을 담을 리스트 생성
		List<Long> idList = new ArrayList<>();

		// 각 BookReviewInfo 객체에서 id를 추출하여 리스트에 추가
		for (BookReviewInfo bookReview : bookReviewInfos) {
		    idList.add(bookReview.getBookId());
		}
		
		List<Book> books = bookRepository.findAllById(idList);
		books.forEach(System.out::println);
		*/
	}
	
	// crudTest2() 메소드가 복잡하니 책 정보와 리뷰 정보를 저장하는 부분을 메소드로 정리한다.
	private Book givenBook() {
		
		Book book = new Book();
		book.setTitle("드래곤볼");
		book.setCategory("애니메이션");
		book.setAuthorId(1L);
		book.setPublisherId(1L);
//		bookRepository.save(book);
//		bookRepository.findAll().forEach(System.out::println);
		
		// Book Entity에 책 정보를 저장하고 저장한 정보를 리턴한다.
		return bookRepository.save(book);
	}
	
	private void givenBookReviewInfo() {
		
		BookReviewInfo bookReviewInfo = new BookReviewInfo();
		// BookReviewInfo Entity에서 private Long bookId를 사용하지 않고 @OneToOne 어노테이션을
		// 사용해서 private Book book와 같이 지정해서 Book Entity와 연관 관계를 설정했으므로
		// 아래 문장을 주석으로 처리한다.
//		bookReviewInfo.setBookId(1L);
		// givenBook() 메소드를 실행한 후 리턴된 결과를 저장한다.
		bookReviewInfo.setBook(givenBook());
		bookReviewInfo.setReviewCount(2);
		bookReviewInfo.setAverageReviewScore(4.5f); 
		bookReviewInfoRepository.save(bookReviewInfo);
		bookReviewInfoRepository.findAll().forEach(System.out::println);
	}
	
	
	
}
